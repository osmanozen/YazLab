@extends('template')
@section('title', 'Kitap Ver')

@section('content')
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Kitap Ver</h6>
                    </div>
                    <div class="card-body">
                            @if(Session::has('error'))
                                <div class="alert alert-danger">
                                    {{ Session::get('error') }}
                                </div>
                            @endif
                            <div class="row">
                                <div class="col-sm-6 offset-3">
                                    <form action="{{ route('give-book') }}" method="POST" enctype="multipart/form-data">
                                        @CSRF
                                        <img id="book_viewer" style="min-height: 200px;width: 100%;">
                                        <div class="form-group">
                                            <label for="book_image">Kitap Resmi: </label>
                                            <input id="book_image" type="file" class="form-control" name="book_image">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Kitabı Ver</button>
                                        <div id="result"></div>
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
        });
    </script>
@endsection