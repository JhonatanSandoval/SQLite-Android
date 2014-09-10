package com.example.ejemplosqlite;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;

import com.example.ejemplosqlite.DetalleActivity;
import com.example.bean.CategoriaBean;
import com.example.adapter.CategoriaAdapter;
import com.example.dao.CategoriaDao;
import com.example.ejemplosqlite.R;
import com.example.util.Constantes;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity {

	private List<CategoriaBean> arrayCategorias;
	private CategoriaDao objCategoriaDao;
	private ListView vistaListaCategoria;
	private CategoriaAdapter categoriaAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// COPIANDO LA BD
		try {
			// CREANDO EL DIRECTORIO
			File theDir = new File(Constantes.PATH_DIRECTORY_DATABASE);
			// if the directory does not exist, create it
			if (!theDir.exists()) {
				boolean result = theDir.mkdir();
				if (result) {
					System.out.println("DIR created");
				}
			}

			File file = new File(Constantes.PATH_DIRECTORY_DATABASE
					+ Constantes.DATABASE_NAME);
			if (!file.exists()) {
				InputStream is = getAssets().open(Constantes.DATABASE_NAME);
				BufferedInputStream bis = new BufferedInputStream(is);
				ByteArrayBuffer baf = new ByteArrayBuffer(50);
				int current = 0;
				while ((current = bis.read()) != -1) {
					baf.append((byte) current);
				}
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(baf.toByteArray());
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		objCategoriaDao = new CategoriaDao(getApplicationContext());
		objCategoriaDao.open();

		vistaListaCategoria = (ListView) findViewById(R.id.listaCategoria);
		categoriaAdapter = new CategoriaAdapter(getApplicationContext());
		vistaListaCategoria.setAdapter(categoriaAdapter);

		vistaListaCategoria.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				CategoriaBean categoria = arrayCategorias.get(position);
				Intent intent = new Intent(MainActivity.this,
						DetalleActivity.class);
				intent.putExtra("categoria", categoria);
				startActivity(intent);
				// Log.d("ITEM CON CLICK", "" + categoria.getCa_descripcion());
			}
		});

		// actualizando de la BD
		arrayCategorias = objCategoriaDao.daoObtenerCategorias();
		categoriaAdapter.actualizarAdapter(arrayCategorias);
	}

}
