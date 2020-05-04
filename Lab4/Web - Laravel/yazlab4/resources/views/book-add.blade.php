@extends('template')
@section('title', 'Kitap Ekle')

@section('content')
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Kitap Ekle</h6>
                    </div>
                    <div class="card-body">
                            @if($errors->any())
                                <ul class="alert alert-danger">
                                    @foreach ($errors->all() as $error)
                                        <li>{{ $error }}</li>
                                    @endforeach
                                </ul>
                            @endif
                            <div class="row">
                                <div class="col-sm-5">
                                    <form id="imageUploadForm" action="javascript:void(0)" method="POST" enctype="multipart/form-data">
                                        @CSRF
                                        <img id="book_viewer" style="min-height: 200px;width: 100%;">
                                        <div class="form-group">
                                            <label for="book_image">Kitap Resmi: </label>
                                            <input id="book_image" type="file" class="form-control" name="book_image">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Resimi İşle</button>
                                        <div id="result"></div>
                                    </form>
                                </div>
                                <div class="col-sm-7">
                                    <form id="bookAdd" action="{{ route('book-add') }}" method="POST">
                                        @CSRF
                                        <input type="text" name="bookImage" id="bookImage" hidden>
                                        <div class="form-group">
                                            <label for="book_isbn">Kitap ISBN: </label>
                                            <input type="text" class="form-control" id="book_isbn" name="book_isbn" placeholder="Kitap ISBN Kodu">
                                        </div>
                                        <div class="form-group">
                                            <label for="book_name">Kitap Adı: </label>
                                            <input type="text" class="form-control" id="book_name" name="book_name" placeholder="Kitap Adı">
                                        </div>
                                        <button type="submit" class="btn btn-success">Kitap Oluştur</button>
                                    </form>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection

@section('js')
    <script>
        $(document).ready(function(){
            $('#book_image').change(function(){
                let reader = new FileReader();
                reader.onload = (e) => {
                    $('#book_viewer').attr('src', e.target.result);
                };
                reader.readAsDataURL(this.files[0]);
            });

            $('#imageUploadForm').on('submit',(function(e) {
                e.preventDefault();
                var formData = new FormData(this);
                $.ajax({
                    type:'POST',
                    url: "{{ route('ajaxImageUpload') }}",
                    data:formData,
                    cache:false,
                    contentType: false,
                    processData: false,
                    success:function(data){
                        var res = $.parseJSON(data);
                        $('#book_isbn').val(res.output);
                        $('#bookImage').val(res.image);
                    }
                });
            }));
        });
    </script>
@endsection