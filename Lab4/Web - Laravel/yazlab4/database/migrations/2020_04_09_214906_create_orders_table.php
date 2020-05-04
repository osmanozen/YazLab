<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateOrdersTable extends Migration{

    public function up(){
        Schema::create('orders', function (Blueprint $table) {
            $table->id();
            $table->integer('u_id');
            $table->integer('b_id');
            $table->date('order_date');
        });
    }

    public function down(){
        Schema::dropIfExists('orders');
    }
}
