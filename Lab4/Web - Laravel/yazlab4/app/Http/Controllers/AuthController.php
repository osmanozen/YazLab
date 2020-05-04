<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class AuthController extends Controller{

    public function __construct() {

        $this->middleware(['auth'], ['only' => [ 'dashboard', 'logout']]);
    }

    public function dashboard(){

        return view('dashboard');
    }

    public function loginForm(){

        return view('login');
    }

    public function login(Request $request){

        $request->validate([
            'email'         => 'required|email|min:8',
            'password'      => 'required|min:6|max:32'
        ]);

        if(auth()->attempt(['email' => $request->email, 'password' => $request->password], $request->has('rememberme'))){

            $request->session()->regenerate();
            return redirect()->intended('/');
        }else{

            return back()->with('error', 'E-Posta veya Şifre yanlış!');
        }
    }

    public function logout(Request $request){

        auth()->logout();
        $request->session()->flush();
        $request->session()->regenerate();
        return redirect()->to('/login');
    }
}
