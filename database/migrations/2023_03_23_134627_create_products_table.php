<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('products', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('description');
            $table->integer('wight');  // gram
            $table->integer('price');
            $table->integer('stock');
            $table->string('images')->nullable();
            $table->integer('sold')->default(0);
            $table->boolean('isActive')->default(true);
            $table->timestamps();
            $table->integer('id_store')->references('id')->on('stores')->onDelete('casecade')->unsigned();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('products');
    }
};
