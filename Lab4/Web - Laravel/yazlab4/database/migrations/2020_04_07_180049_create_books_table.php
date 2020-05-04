<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateBooksTable extends Migration{

    public function up(){
        Schema::create('books', function (Blueprint $table) {
            $table->id();
            $table->string('book_name', 120);
            $table->string('book_isbn', 30);
            $table->string('book_image', 60);
            $table->boolean('book_status')->default(true);
        });
    }

    public function down(){
        Schema::dropIfExists('books');
    }
}
