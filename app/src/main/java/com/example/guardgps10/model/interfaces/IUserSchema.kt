package com.example.guardgps10.model.interfaces

interface IUserSchema {

    private val user_table          : String
        get() = "persona"
    private val columna__nickname   : String
        get() = "nickname"
    private val columna__nombre     : String
        get() = "nombre"
    private val columna_apellido    : String
        get() = "apellido"
    private val columna_tipo_documento : String
        get() = "tipo_documento"
    private val columna_documento  : String
        get() = "documento"
    private val columna_estado      : String
        get() = "estado"
    private val user_table_create   : String
        get() = "CREATE TABLE IF NOT EXISTS " + user_table + " (" + columna__nickname + " TEXT NOT NULL, " + columna__nombre + " TEXT NOT NULL," + columna_apellido +  " TEXT NOT NULL, " + columna_tipo_documento + " INTEGER, " + columna_documento + " TEXT NOT NULL, " + columna_estado + " INTEGER, " + " )";

//    val user_columns : Array = String{ }

    var USER_COLUMNS: Array<String>
        get() = arrayOf<String>(
            columna__nickname, columna__nombre, columna_apellido, columna_tipo_documento, columna_documento, columna_estado
        )
        set(value) = TODO()
}