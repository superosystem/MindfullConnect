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
        Schema::create('address_stores', function (Blueprint $table) {
            $table->id();
            $table->string('address');
            $table->string('province');
            $table->string('city');
            $table->string('district')->nullable();
            $table->string('postal_code');
            $table->string('email');
            $table->string('phone');
            $table->boolean('isActive')->default(true);
            $table->integer('id_province')->nullable();
            $table->integer('id_city')->nullable();
            $table->integer('id_district')->nullable();
            $table->timestamps();
            $table->integer('id_store')->references('id')->on('stores')->onDelete('casecade')->nullable();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('address_stores');
    }
};
