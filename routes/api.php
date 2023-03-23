<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::prefix('v1')->group(function() {
    Route::post('signin', [App\Http\Controllers\Api\AuthController::class, 'signin']);
    Route::post('signup', [App\Http\Controllers\Api\AuthController::class, 'signup']);

    Route::put('user/{id}', [App\Http\Controllers\Api\UserController::class, 'update']);
    Route::get('user/image/{filename}', [App\Http\Controllers\Api\UserController::class, 'image']);
    Route::post('user/image/{id}', [App\Http\Controllers\Api\UserController::class, 'upload']);
});
