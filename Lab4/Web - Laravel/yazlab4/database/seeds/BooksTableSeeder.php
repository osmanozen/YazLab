<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class BooksTableSeeder extends Seeder{

    public function run(){

        $array = [
            ['book_name' => 'Şeker Portakalı', 'book_isbn' => '9789750738609', 'book_image' => 'seker-portakali.jpg'],
            ['book_name' => 'Körlük: 1998', 'book_isbn' => '9786052980811', 'book_image' => 'korluk-1998.jpg'],
            ['book_name' => 'Hiçbir Karşılaşma Tesadüf Değildir', 'book_isbn' => '9786053117384', 'book_image' => 'hicbir-karsilasma-tesaduf-degildir.jpg'],
            ['book_name' => 'Gör Beni-İki Devrin Hikayesi', 'book_isbn' => '9786051853635', 'book_image' => 'gor-beni.jpg'],
            ['book_name' => 'Bir Ömür Nasıl Yaşanır?', 'book_isbn' => '9789752430990', 'book_image' => 'bir-omur-nasil-yasanir.jpg']
        ];

        foreach ($array as $arr) {
            DB::table('books')->insert([
                $arr
            ]);
        }
    }
}
