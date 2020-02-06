'use strict';

const functions = require('firebase-functions');
const mkdirp = require('mkdirp-promise');
const admin = require('firebase-admin');
admin.initializeApp();
const spawn = require('child-process-promise').spawn;
const path = require('path');
const os = require('os');
const fs = require('fs');

const db  = admin.database();
const ref = db.ref("/user/compress");
var value;

ref.on("value", function(snapshot){
  value = snapshot.val();
});

const THUMB_PREFIX = 'compress_';

exports.generateCompression = functions.storage.object().onFinalize(async (object) => {
  const filePath = object.name;
  const contentType = object.contentType;
  const fileDir = path.dirname(filePath);
  const fileName = path.basename(filePath);
  const thumbFilePath = path.normalize(path.join(fileDir, `${THUMB_PREFIX}${fileName}`));
  const tempLocalFile = path.join(os.tmpdir(), filePath);
  const tempLocalDir = path.dirname(tempLocalFile);
  const tempLocalThumbFile = path.join(os.tmpdir(), thumbFilePath);

  if (!contentType.startsWith('image/')) {
    return console.log('This is not an image.');
  }

  if (fileName.startsWith(THUMB_PREFIX)) {
    return console.log('Already a Compress Image.');
  }

  const bucket = admin.storage().bucket(object.bucket);
  const file = bucket.file(filePath);
  const thumbFile = bucket.file(thumbFilePath);
  const metadata = {
    contentType: contentType
  };

  await mkdirp(tempLocalDir)
  await file.download({destination: tempLocalFile});
  console.log('The file has been downloaded to', tempLocalFile);
  await spawn('convert', [tempLocalFile, '-quality', `${value}`, tempLocalThumbFile], {capture: ['stdout', 'stderr']});
  console.log('Compress Image created at', tempLocalThumbFile);
  await bucket.upload(tempLocalThumbFile, {destination: thumbFilePath, metadata: metadata});
  console.log('Compress Image uploaded to Storage at', thumbFilePath);
  fs.unlinkSync(tempLocalFile);
  fs.unlinkSync(tempLocalThumbFile);

  const config = {
    action: 'read',
    expires: '03-01-2500',
  };
  const results = await Promise.all([
    thumbFile.getSignedUrl(config),
    file.getSignedUrl(config),
  ]);
});