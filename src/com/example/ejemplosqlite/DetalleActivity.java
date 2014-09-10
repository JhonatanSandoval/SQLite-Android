package com.example.ejemplosqlite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bean.CategoriaBean;
import com.example.ejemplosqlite.R;

public class DetalleActivity extends Activity {
	TextView titulo;
	private CategoriaBean categoria;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);

		Bundle extra = getIntent().getExtras();
		categoria = (CategoriaBean) extra.get("categoria");

		titulo = (TextView) findViewById(R.id.titulo);
		titulo.setText(categoria.getCat_descripcion());
	}

}
