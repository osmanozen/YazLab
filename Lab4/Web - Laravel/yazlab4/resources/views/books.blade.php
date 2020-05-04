@extends('template')
@section('title', 'Kitap Listesi')

@section('content')
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div style="display: flex;flex-direction: column;align-items: flex-end;">
                    <a href="{{ route('book-add-form') }}" class="btn btn-primary btn-icon-split mb-2">
                        <span class="icon text-white-50"><i class="fas fa-plus"></i></span>
                        <span class="text">Kitap Ekle</span>
                    </a>
                </div>

                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Kitap Listesi</h6>
                    </div>
                    <div class="card-body">
                        @if(Session::has('msg'))
                            <div class="alert alert-success">
                                {{ Session::get('msg') }}
                            </div>
                        @endif
                        <div class="table-responsive">
                            <table class="table table-bordered table-condensed table-striped">
                                <thead>
                                    <th>ID</th>
                                    <th>Kitap Resim</th>
                                    <th>Kitap ISBN</th>
                                    <th>Kitap Adı</th>
                                </thead>
                                <tbody>
                                    @foreach($data as $row)
                                        <tr>
                                            <td>{{$row->id }}</td>
                                            <td style="text-align: center;"><img src="{{ asset('img/'.$row->book_image) }}" style="width: 70px;"></td>
                                            <td>{{$row->book_isbn }}</td>
                                            <td>{{$row->book_name }}</td>
                                        </tr>
                                    @endforeach
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection