@extends('template')
@section('title', 'Kullanıcı Listesi')

@section('content')
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Kullanıcı Listesi</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-condensed table-striped">
                                <thead>
                                    <th>Kullanıcı</th>
                                    <th>Kitap Resim</th>
                                    <th>Kitap ISBN</th>
                                    <th>Kitap Adı</th>
                                </thead>
                                <tbody>
                                    @foreach($data as $row)
                                        <tr>
                                            <td>{{$row->name }}</td>
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