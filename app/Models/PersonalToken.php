<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class PersonalToken extends Model
{
    use HasFactory;

    protected $fillable = [
        'id_user',
        'token',
        'abilities',
        'lastUsedAt',
    ];

    public function user(): BelongsTo {
        return $this->belongsTo(User::class, "id_user", "id");
    }
}
