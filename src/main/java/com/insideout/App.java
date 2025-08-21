package com.insideout;

import com.insideout.controller.MomentoController;
import com.insideout.repository.DiarioEnMemoria;
import com.insideout.repository.DiarioRepository;
import com.insideout.view.ConsolaView;

public class App {
    public static void main(String[] args) {
        DiarioRepository diarioRepository = new DiarioEnMemoria();
        ConsolaView consolaView = new ConsolaView();
        MomentoController momentoController = new MomentoController(diarioRepository, consolaView);

        momentoController.iniciar();
    }
}
