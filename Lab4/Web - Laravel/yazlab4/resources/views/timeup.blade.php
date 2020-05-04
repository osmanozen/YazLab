@extends('template')
@section('title', 'Zaman Atlama')

@section('content')
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Zaman Atlama</h6>
                    </div>
                    <div class="card-body">
                        @if(Session::has('msg'))
                            <div class="alert alert-success">
                                {{ Session::get('msg') }}
                            </div>
                        @endif
                        @if($errors->any())
                            <ul class="alert alert-danger">
                                @foreach ($errors->all() as $error)
                                    <li>{{ $error }}</li>
                                @endforeach
                            </ul>
                        @endif
                        <form action="{{ route('timeup') }}" method="POST">
                            @CSRF
                            <div class="form-group">
                                <label for="system_time">Zaman: </label>
                                <input class="datepicker form-control" id="system_time" name="system_time" value="{{ $data->system_time }}">
                            </div>
                            <button type="submit" class="btn btn-success">Zaman Atla</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
@section('js')
    <script>
        $('.datepicker').datepicker({
            format: 'yyyy-mm-dd',
            language: "tr"
        });
    </script>
@endsection