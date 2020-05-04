@extends('template')
@section('title', 'Kitap Al')

@section('content')
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">

                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Kitap Arama</h6>
                    </div>
                    <div class="card-body">
                        <form action="{{ route('take-book-form') }}" method="GET">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <input type="text" class="form-control" name="book_isbn" value="{{ Request('book_isbn') }}" placeholder="Kitap ISBN Kodu">
                                </div>
                                <div class="col-sm-6 form-group">
                                    <input type="text" class="form-control" name="book_name" value="{{ Request('book_name') }}" placeholder="Kitap Adı">
                                </div>
                                <button type="submit" class="btn btn-primary btn-icon-split mb-2">
                                    <span class="icon text-white-50"><i class="fas fa-plus"></i></span>
                                    <span class="text">Kitap Ara</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Kitap Listesi</h6>
                    </div>
                    <div class="card-body">
                        @if(Session::has('success'))
                            <div class="alert alert-success">
                                {{ Session::get('success') }}
                            </div>
                        @endif
                        @if(Session::has('error'))
                            <div class="alert alert-danger">
                                {{ Session::get('error') }}
                            </div>
                        @endif
                        <div class="table-responsive">
                            <table class="table table-bordered table-condensed table-striped">
                                <thead>
                                    <th>ID</th>
                                    <th>Kitap Resim</th>
                                    <th>Kitap ISBN</th>
                                    <th>Kitap Adı</th>
                                    <th>Durum</th>
                                    <th>Aksiyonlar</th>
                                </thead>
                                <tbody>
                                    @foreach($data as $row)
                                        <tr>
                                            <td>{{$row->id }}</td>
                                            <td style="text-align: center;"><img src="{{ asset('img/'.$row->book_image) }}" style="width: 70px;"></td>
                                            <td>{{$row->book_isbn }}</td>
                                            <td>{{$row->book_name }}</td>
                                            <td>
                                                @if($row->book_status==true)
                                                    <div class="musait">Müsait</div>
                                                @else
                                                    <div class="musait-degil">Müsait Değil</div>
                                                @endif
                                            </td>
                                            <td style="text-align: center;">
                                                @if($row->book_status==true)
                                                    <a href="{{ route('take-book', $row->id ) }}" class="btn btn-warning btn-circle">
                                                        <i class="fas fa-credit-card"></i>
                                                    </a>
                                                @else
                                                    <a class="btn btn-warning btn-circle disabled">
                                                        <i class="fas fa-credit-card"></i>
                                                    </a>
                                                @endif
                                            </td>
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