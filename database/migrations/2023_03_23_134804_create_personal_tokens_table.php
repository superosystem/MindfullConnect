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
        Schema::create('personal_tokens', function (Blueprint $table) {
            $table->id();
            $table->string('token')->nullable();
            $table->string('abilities')->nullable();
            $table->timestamp('lastUsedAt')->nullable();
            $table->timestamps();
            $table->integer('id_user')->references('id')->on('users')->onDelete('casecade')->default(0);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('personal_tokens');
    }
};
