<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\File;
use Illuminate\Support\Facades\Storage;

class UserController extends Controller
{
    public function update(Request $request, $id)
    {
        $user = User::where('id', $id)->first();
        if ($user) {
            $user->update($request->all());
            return $this->jsonResponse($user);
        }

        return $this->errorResponse(404, "user is not found");
    }

    public function upload(Request $request, $id)
    {
        $user = User::where('id', $id)->first();
        if ($user) {
            if ($request->hasFile('image')) {
                // delete old image
                $path = 'storage/images/user/' . $user->image;
                if (File::exists($path)) {
                    File::delete($path);
                }
                $file = $request->file('image');
                $ext =  $file->getClientOriginalExtension();
                // rename image
                $newFilename = $user->name . time() . '.' . $ext;
                // save image to public folder
                $file->move('storage/images/user', $newFilename);
                $user->image = $newFilename;
            } else {
                return $this->errorResponse(400, "image should attach");
            }

            $user->update([
                'image' => $newFilename
            ]);
            return $this->jsonResponse($user);
        }
        return $this->errorResponse(400, "cannot upload image");
    }

    public function image($filename)
    {
        $path = '/storage/images/user/' . $filename;
        return url('/') . $path;
    }

    private function jsonResponse($data, $code = 200, $message = 'success')
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
