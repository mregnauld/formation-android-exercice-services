package com.formationandroid.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity
{
	
	// Service :
	private CompteurService compteurService = null;
	
	// Vues :
	private Button buttonCompteur = null;
	
	
	/**
	 * Callback pour le binding, via un ServiceConnection.
	 */
	private ServiceConnection connexion = new ServiceConnection()
	{
		@Override
		public void onServiceConnected(ComponentName className, IBinder binder)
		{
			// récupération du service :
			compteurService = ((CompteurService.MonBinder) binder).getService();
			
			// actualisation du libellé du bouton :
			String valeur = Integer.toString(compteurService.getCompteur());
			buttonCompteur.setText(valeur);
		}
		
		@Override
		public void onServiceDisconnected(ComponentName className)
		{
			compteurService = null;
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		// vues :
		buttonCompteur = findViewById(R.id.bouton_compteur);
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		
		// binding au service, pour avoir une référence sur ce dernier :
		Intent intent = new Intent(this, CompteurService.class);
		bindService(intent, connexion, Context.BIND_AUTO_CREATE);
	}
	
	/**
	 * Listener clic bouton compteur.
	 * @param view Bouton
	 */
	public void onClickCompteur(View view)
	{
		String valeur = Integer.toString(compteurService.getCompteurIncremente());
		buttonCompteur.setText(valeur);
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		
		if (compteurService != null)
		{
			// déconnexion du service :
			unbindService(connexion);
		}
	}
	
}
