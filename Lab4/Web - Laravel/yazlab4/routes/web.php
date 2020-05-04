<?php

use Illuminate\Support\Facades\Route;

Route::get('/', 'AuthController@dashboard');
Route::get('/login', 'AuthController@loginForm');
Route::post('/login', 'AuthController@login')->name('login');
Route::post('/logout', 'AuthController@logout')->name('logout');

Route::get('/book-list', 'AdminController@bookList')->name('book-list');
Route::get('/book-add', 'AdminController@bookAddForm')->name('book-add-form');
Route::post('/book-add', 'AdminController@bookAdd')->name('book-add');
Route::post('/image-upload', 'AdminController@ajaxImageUploadPost')->name('ajaxImageUpload');
Route::get('/timeup', 'AdminController@timeUpForm')->name('timeup-form');
Route::post('/timeup', 'AdminController@timeUp')->name('timeup');
Route::get('/orders', 'AdminController@orders')->name('orders');

Route::any('/take-book', 'UserController@takeBookForm')->name('take-book-form');
Route::get('/take-book/{id?}', 'UserController@takeBook')->name('take-book');
Route::get('/give-book', 'UserController@giveBookForm')->name('give-book-form');
Route::post('/give-book', 'UserController@giveBook')->name('give-book');
