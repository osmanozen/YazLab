<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Osman ÖZEN, Ramazan Fatih ÇARDAK">
    <meta name="csrf-token" content="{{ csrf_token() }}">
    <title>Giriş Yap - YazLab4</title>

    <!-- Custom fonts for this template-->
    <link href="{{ asset('vendor/fontawesome-free/css/all.min.css') }}" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="{{ asset('css/sb-admin-2.min.css') }}" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block align-content-center" style="padding: 30px 100px;">
                            <img src="/kou.png" style="width: 100%;">
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Giriş Yap</h1>
                                </div>

                                @if(Session::has('error'))
                                    <div class="card mb-4 py-3 border-left-danger">
                                        <p style="padding-left: 1.25rem;color: #e85547;font-weight: bold;"> HATA!</p>
                                        <div class="card-body" style="padding:0 1.25rem">
                                            {{ Session::get('error') }}
                                        </div>
                                    </div>
                                    @php Session::forget('error'); @endphp
                                @endif
                                <form method="POST" action="{{ route('login') }}">
                                    @CSRF
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" name="email" id="email" placeholder="E-Posta">
                                        @if ($errors->has('email'))
                                            <span class="text-danger">{{ $errors->first('email') }}</span>
                                        @endif
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user" name="password" id="password" placeholder="Şifre">
                                        @if ($errors->has('password'))
                                            <span class="text-danger">{{ $errors->first('password') }}</span>
                                        @endif
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input"  id="customCheck">
                                            <label class="custom-control-label" for="customCheck">Beni Hatırla</label>
                                        </div>
                                    </div>

                                    <button type="submit" style="float:right;" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50"><i class="fas fa-arrow-right"></i></span>
                                        <span class="text">Giriş Yap</span>
                                    </button>
                                </form>
                                <br><br>
                                <hr>
                                <div class="row no-gutters justify-content-center mb-4">
                                    Kolay giriş :
                                    <div class="col-md-6" style="text-align:center;">

                                        <button type="button" class="btn-demo" onclick="yoneticiLogin()">yönetici</button>
                                        <button type="button" class="btn-demo" onclick="kullaniciLogin()">kullanıcı</button>
                                    </div>
                                </div>
                                <style type="text/css">
                                    .btn-demo {
                                        background-color: #77838f;
                                        color: #fff;
                                        border: 0px;
                                        padding: 5px 13px;
                                        font-weight: 500;
                                        margin: 2px;
                                        border-radius: 20px;
                                    }
                                </style>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>
<script type="text/javascript">

    function yoneticiLogin() {
        document.getElementById('email').value = 'yonetici@test.com';
        document.getElementById('password').value = '123456';
    }
    function kullaniciLogin() {
        document.getElementById('email').value = 'kullanici@test.com';
        document.getElementById('password').value = '123456';
    }

</script>

<!-- Bootstrap core JavaScript-->
<script src="{{ asset('vendor/jquery/jquery.min.js') }}"></script>
<script src="{{ asset('vendor/bootstrap/js/bootstrap.bundle.min.js') }}"></script>

<!-- Core plugin JavaScript-->
<script src="{{ asset('vendor/jquery-easing/jquery.easing.min.js') }}"></script>

<!-- Custom scripts for all pages-->
<script src="{{ asset('js/sb-admin-2.min.js') }}"></script>

</body>

</html>
