<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasOne;

class Product extends Model
{
    use HasFactory;

    protected $fillable = [
        'id_store',
        'id_category',
        'name',
        'description',
        'wight', // gram
        'price',
        'stock',
        'images',
        'isActive',
        'sold',
    ];

    protected $casts = [
        'isActive' => 'boolean'
    ];

    public function category(): HasOne {
        return $this->hasOne(Category::class, "id", "id_category");
    }

    public function store(): HasOne {
        return $this->hasOne(Toko::class, "id", "id_store");
    }
}
