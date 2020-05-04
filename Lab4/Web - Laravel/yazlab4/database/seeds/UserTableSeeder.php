<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class UserTableSeeder extends Seeder{

    public function run(){

        DB::table('users')->insert([
                'name' => 'Kütüphane Yöneticisi',
                'email' => 'yonetici@test.com',
                'password' => Hash::make('123456'),
                'isAdmin' => true
            ]);

        DB::table('users')->insert([
            'name' => 'Kütüphane Kullanıcısı',
            'email' => 'kullanici@test.com',
            'password' => Hash::make('123456'),
            'isAdmin' => false
        ]);

        DB::table('users')->insert([
            'name' => 'Kütüphane Kullanıcısı 2',
            'email' => 'kullanici2@test.com',
            'password' => Hash::make('123456'),
            'isAdmin' => false
        ]);
    }
}
