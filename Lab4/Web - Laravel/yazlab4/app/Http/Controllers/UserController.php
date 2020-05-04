<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Auth;


class UserController extends Controller{

    public function __construct() {

        $this->middleware(['auth']);
    }

    public function takeBookForm(Request $request){

        $data = DB::table('books')->orderBy('id','desc');

        if(isset($request->book_isbn)){
            $data = $data->where('book_isbn', 'like', '%'.$request->book_isbn.'%');
        }

        if(isset($request->book_name)){
            $data = $data->where('book_name', 'like', '%'.$request->book_name.'%');
        }
        $data = $data->get();
        return view('take-book',compact(['data']));
    }

    public function takeBook(Request $request, $id){

        if(Auth::user()->isAdmin==true){

            return back()->with('error', 'Kütüphane Yöneticisi kitap alamaz.');
        }

        $count = DB::table('orders')->where('u_id', Auth::user()->id)->count();
        if($count >= 3){

            return back()->with('error', '3\'den fazla kitap alamazsınız.');
        }

        $books  = DB::table('orders')->select('order_date')->where('u_id', Auth::user()->id)->get();
        $system_date   = DB::table('settings')->select('system_time')->first();
        $system_date   = strtotime($system_date->system_time);
        foreach ($books as $book){
            $date = strtotime($book->order_date);
            $datediff = abs($system_date-$date);
            if(round($datediff / (60 * 60 * 24))>7){

                return back()->with('error', 'Üstünüzde tarihi geçmiş kitap bulunmaktadır.');
            }
        }

        DB::table('orders')->insert([
            'u_id'          => Auth::user()->id,
            'b_id'          => $id,
            'order_date'    => date('Y-m-d')
        ]);

        DB::table('books')->where('id', $id)->update([
            'book_status'   => false
        ]);

        return back()->with('success', 'Kitabı başarılı bir şekilde aldınız.');
    }

    public function giveBookForm(){

        return view('give-book');
    }

    public function giveBook(Request $request){

        if($request->has('book_image')) {
            $image = $request->file('book_image');
            $name = time(). '.' . $image->getClientOriginalExtension();
            $image->move(public_path('img'), $name);
        }
        $output = shell_exec('C:\Users\OSMAN\AppData\Local\Programs\Python\Python38-32\python .\detect_barcode.py --image '.public_path('img').'\\'.$name.' 2>&1');
        $output = preg_replace('/[^0-9]/', '', $output);

        $data = DB::table('orders')
                ->join('books', 'orders.b_id', '=', 'books.id')
                ->where('book_isbn','=',$output)
                ->first();

        if(isset($data)){

            DB::table('orders')->where('b_id', $data->b_id)->delete();
            DB::table('books')->where('book_isbn',$output)->update([
                'book_status' => true
            ]);

            return redirect()->route('take-book-form')->with('success', 'Kitap başarılı bir şekilde teslim edilmiştir.');
        }else{

            return back()->with('error', 'Kitap, teslim edilecekler arasında yer almamaktadır.');
        }
    }
}
