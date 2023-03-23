<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class AddressStore extends Model
{
    use HasFactory;

    protected $fillable = [
        'alamat',
        'province',
        'city',
        'district',
        'postal_code',
        'phone',
        'email',
        'isActive',
        'id_province',
        'id_city',
        'id_district',
        'id_store',
    ];

    protected $casts = [
        'isActive' => 'boolean'
    ];

}
