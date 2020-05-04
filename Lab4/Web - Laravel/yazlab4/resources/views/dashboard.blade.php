@extends('template')
@section('title', 'Dashboard')

@section('content')
    <div class="container-fluid">

        <h1 class="h3 mb-4 text-gray-800">Kütüphane Otomasyonu</h1>

        <div class="row">
            <div class="col-lg-12">

                <!-- Circle Buttons -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Hoşgeldin,</h6>
                    </div>
                    <div class="card-body">
                        <div class="mb-2">
                            <span>Kullanıcı: </span>
                            <code>{{ \Illuminate\Support\Facades\Auth::user()->name }}</code>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection