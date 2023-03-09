<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class AuthController extends Controller
{
    public function signin(Request $request)
    {
        $validate = Validator::make($request->all(), $this->rulesSignin());
        if ($validate->fails()) {
            return $this->errorResponse(400, $validate->errors()->first());
        }

        $user = User::where('email', $request->email)->first();
        if ($user) {
            if (Hash::check($request->password, $user->password)) {
                return $this->jsonResponse($user);
            }else{
                return $this->errorResponse(400, 'Password is wrong');
            }
        } else {
            return $this->errorResponse(404, 'Email is not register');
        }
    }

    public function signup(Request $request)
    {
        $validate = Validator::make($request->all(), $this->rulesSignup());
        if ($validate->fails()) {
            return $this->errorResponse(400, $validate->errors()->first());
        }

        $user = User::create(array_merge($request->all(), [
            'password' => bcrypt($request->password),
        ]));
        if ($user) {
            return $this->jsonResponse($user);
        } else {
            return $this->errorResponse(400, 'Bad Request');
        }
    }

    private function rulesSignin()
    {
        return [
            'email' => 'required|email|max:100',
            'password' => 'required|min:8'
        ];
    }

    private function rulesSignup()
    {
        return [
            'name' => 'required',
            'email' => 'required|unique:users|email|max:100',
            'phone' => 'required|unique:users',
            'password' => 'required|min:8'
        ];
    }

    private function jsonResponse($data, $code=200, $message='success')
    {
        return response()->json([
            'code' => $code,
            'message' => $message,
            'data' => $data
        ], $code);
    }


    private function errorResponse($code, $message)
    {
        return response()->json([
            'code' => $code,
            'message' => $message,
        ], $code);
    }
}
