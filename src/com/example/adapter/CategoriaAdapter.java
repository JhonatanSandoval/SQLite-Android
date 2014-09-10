package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.ejemplosqlite.R;
import com.example.bean.CategoriaBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoriaAdapter extends BaseAdapter {

	private Context mContext;
	private List<CategoriaBean> listaCategorias;
	LayoutInflater mLayoutInflater;

	public CategoriaAdapter(Context context) {
		mContext = context;
		mLayoutInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		listaCategorias = new ArrayList<CategoriaBean>();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaCategorias.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listaCategorias.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemView;

		if (convertView == null) {
			itemView = (LinearLayout) mLayoutInflater.inflate(
					R.layout.list_row, parent, false);
		} else {
			itemView = (LinearLayout) convertView;
		}

		CategoriaBean categoria = listaCategorias.get(position);

		TextView titulo = (TextView) itemView.findViewById(R.id.titulo);
		TextView subTitulo = (TextView) itemView.findViewById(R.id.subtitulo);
		titulo.setText(categoria.getCat_descripcion());
		subTitulo.setText(categoria.getCat_plataforma());

		return itemView;
	}

	public void actualizarAdapter(List<CategoriaBean> listaC) {
		listaCategorias = listaC;
		notifyDataSetChanged();
	}

}
