package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.CategoriaBean;
import com.example.dao.CreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CategoriaDao {

	// campos de la BD
	public static final String CAT_ID = "cat_id";
	public static final String CAT_PLATAFORMA = "cat_plataforma";
	public static final String CAT_DESCRIPCION = "cat_descripcion";
	public static final String CAT_ESTADO = "cat_estado";

	private static final String DATABASE_TABLE = "categoria";

	private Context context;
	private SQLiteDatabase database;
	private CreateDatabase dbHelper;

	public CategoriaDao(Context context) {
		this.context = context;
	}

	public CategoriaDao open() throws SQLException {
		dbHelper = new CreateDatabase(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public void daoCrearCategoria(com.example.bean.CategoriaBean categoria) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(CAT_ID, categoria.getCat_id());
		initialValues.put(CAT_PLATAFORMA, categoria.getCat_plataforma());
		initialValues.put(CAT_DESCRIPCION, categoria.getCat_descripcion());
		initialValues.put(CAT_ESTADO, categoria.getCat_estado());
		database.insert(DATABASE_TABLE, null, initialValues);
		Log.d("SQL", "INSERTO EN LA TABLA CLIENTE");
	}

	public List<CategoriaBean> daoObtenerCategorias() {
		List<CategoriaBean> result = new ArrayList<CategoriaBean>();
		Cursor cursor = database.query(DATABASE_TABLE, new String[] {
				CAT_ID, CAT_PLATAFORMA, CAT_DESCRIPCION, CAT_ESTADO }, null, null, null, null, null);
		while (cursor.moveToNext()) {
			CategoriaBean categoria = new CategoriaBean();
			categoria.setCat_id(cursor.getString(cursor
					.getColumnIndex(CAT_ID)));
			categoria.setCat_plataforma(cursor.getString(cursor
					.getColumnIndex(CAT_PLATAFORMA)));
			categoria
					.setCat_descripcion(cursor.getString(cursor.getColumnIndex(CAT_DESCRIPCION)));
			categoria.setCat_estado(cursor.getString(cursor
					.getColumnIndex(CAT_ESTADO)));
			result.add(categoria);
		}
		return result;
	}

}
