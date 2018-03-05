package com.example.patrick.kospen5ui_test.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patrick.kospen5ui_test.R;
import com.example.patrick.kospen5ui_test.validator.ValidationHelper;


public class FragmentTwo extends Fragment {

    //TextInputLayout variables
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutAge;
    private TextInputLayout textInputLayoutPassword;

    //EditText variables
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextAge;
    private EditText editTextPassword;

    //Button
    private Button buttonSignUp;

    //Input validator
    private ValidationHelper validation;


    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        textInputLayoutName = (TextInputLayout) rootView.findViewById(R.id.text_input_layout_name);
        textInputLayoutEmail = (TextInputLayout) rootView.findViewById(R.id.text_input_layout_email);
        textInputLayoutAge = (TextInputLayout) rootView.findViewById(R.id.text_input_layout_age);
        textInputLayoutPassword = (TextInputLayout) rootView.findViewById(R.id.text_input_layout_password);

        editTextName = (EditText) rootView.findViewById(R.id.edit_text_name);
        editTextEmail = (EditText) rootView.findViewById(R.id.edit_text_email);
        editTextAge = (EditText) rootView.findViewById(R.id.edit_text_age);
        editTextPassword = (EditText) rootView.findViewById(R.id.edit_text_password);

        buttonSignUp = (Button) rootView.findViewById(R.id.button_sign_up);

        validation = new ValidationHelper(getContext());

        initListeners();

        return rootView;
    }


    // To initialize views objects
    private void initViews() {
//        textInputLayoutName = (TextInputLayout) findViewById(R.id.text_input_layout_name);
//        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.text_input_layout_email);
//        textInputLayoutAge = (TextInputLayout) findViewById(R.id.text_input_layout_age);
//        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);
//
//        editTextName = (EditText) findViewById(R.id.edit_text_name);
//        editTextEmail = (EditText) findViewById(R.id.edit_text_email);
//        editTextAge = (EditText) findViewById(R.id.edit_text_age);
//        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
//
//        buttonSignUp = (Button) findViewById(R.id.button_sign_up);

//        validation = new ValidationHelper(this);


    }

    // To initialize listeners
    private void initListeners() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkValidation();
            }
        });
    }

    // method for validation of form on sign up button click
    private void checkValidation() {
        if (!validation.isEditTextFilled(editTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }

        if (!validation.isEditTextEmail(editTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }

        if (!validation.isEditTextFilled(editTextAge, textInputLayoutAge, getString(R.string.error_message_age))) {
            return;
        }
        if (!validation.isEditTextFilled(editTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }

        Toast.makeText(getContext(), getString(R.string.success_message), Toast.LENGTH_LONG).show();
    }


}