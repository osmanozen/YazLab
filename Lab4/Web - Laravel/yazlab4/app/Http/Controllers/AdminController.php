<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class AdminController extends Controller{

    public function __construct() {

        $this->middleware(['auth']);
    }

    public function bookList(){

        $data = DB::table('books')->orderBy('id','desc')->get();
        return view('books',compact(['data']));
    }

    public function bookAddForm(){

        return view('book-add');
    }

    public function ajaxImageUploadPost(Request $request){

        if($request->has('book_image')) {
            $image = $request->file('book_image');
            $name = time(). '.' . $image->getClientOriginalExtension();
            $image->move(public_path('img'), $name);
        }
        $data['image'] = $name;

        //https://stackoverflow.com/questions/55494857/python-is-not-recognized-as-an-internal-or-external-command-operable-program
        $output = shell_exec('C:\Users\OSMAN\AppData\Local\Programs\Python\Python38-32\python .\detect_barcode.py --image '.public_path('img').'\\'.$name.' 2>&1');
        $output = preg_replace('/[^0-9]/', '', $output);
        $data['output']=$output;
        echo json_encode($data);
    }

    public function bookAdd(Request $request){

        $request->validate([
            'book_isbn'     => 'required|min:10|max:17',
            'book_name'     => 'required|min:5'
        ]);

        DB::table('books')->insert([
            'book_name'     => $request->input('book_name'),
            'book_isbn'     => $request->input('book_isbn'),
            'book_image'    => $request->input('bookImage'),
        ]);

        return redirect()->route('book-list')->with('msg', 'Kitap başarılı bir şekilde eklenmiştir.');
    }

    public function timeupForm(){

        $data = DB::table('settings')->select('system_time')->first();
        return view('timeup', compact(['data']));
    }

    public function timeup(Request $request){

        $request->validate([
            'system_time' => 'required'
        ]);


        DB::table('settings')->update([
            'system_time' => $request->input('system_time')
        ]);

        return back()->with('msg', 'Tarih başarılı bir şekilde değiştirilmiştir.');

    }

    public function orders(){

        $data = DB::table('orders')
                ->join('users', 'orders.u_id', '=', 'users.id')
                ->join('books', 'orders.b_id', '=', 'books.id')
                ->get();
        return view('orders',compact(['data']));
    }


}
