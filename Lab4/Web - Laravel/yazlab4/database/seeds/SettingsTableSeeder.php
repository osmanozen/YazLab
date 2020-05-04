<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Carbon;

class SettingsTableSeeder extends Seeder{

    public function run(){

        DB::table('settings')->insert([
           'system_time' => Carbon::now()->format('Y-m-d')
        ]);
    }
}
