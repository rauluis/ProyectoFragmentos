package elrizo.com.fragmentos.gui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import elrizo.com.fragmentos.databinding.FragmentLoginBinding;
import elrizo.com.fragmentos.gui.components.NavigationHost;


public class LoginFragment extends Fragment {


    private FragmentLoginBinding binding;
    private View view;
    private Context context;
    private MaterialButton btnLogin;
    private TextInputEditText txtUser;
    private TextInputEditText txtPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        configGlobals();
        configView(inflater, container);
        configListeners();
        return view;
    }

    private void configListeners() {
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost)MainActivity.GLOBALS.get("app")).navigateTo(new TopJuegos(), false);

            }
        });
        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);

            }
        });
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("loginFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        context = container.getContext();

    }




}