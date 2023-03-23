<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasOne;

class Store extends Model
{
    use HasFactory;

    protected $fillable = [
        'name',
        'city',
        'image',
        'id_user',
        'id_address'
    ];

    public function address(): HasOne {
        return $this->hasOne(AddressStore::class, "id_store", "id");
    }
}
