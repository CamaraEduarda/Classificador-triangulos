package br.edu.ifpb.es.tdt.triangulo.rest;


import br.edu.ifpb.es.tdt.triangulo.model.ClassificacaoTriangulo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/triangulo")
public class ClassificacaoTrianguloRestController implements ClassificacaoTrianguloRestControllerApi {

    @GetMapping("/classificar")
    public ResponseEntity<ClassificacaoTriangulo> getClassificacaoTriangulo(@RequestParam String lado1,
                                                                            @RequestParam String lado2,
                                                                            @RequestParam String lado3) {
                                                                            
        int valor1 = Integer.parseInt(lado1);
        int valor2 = Integer.parseInt(lado2);
        int valor3 = Integer.parseInt(lado3);
        
        if (!((valor1 + valor2 > valor3) && (valor1 + valor3 > valor2) && (valor2 + valor3 > valor1))) {
            return new ResponseEntity<>(ClassificacaoTriangulo.INVÁLIDO, HttpStatus.BAD_REQUEST);
        }

        if ((valor1 == valor2) && (valor2 == valor3) && (valor1 == valor3)) {
            return new ResponseEntity<>(ClassificacaoTriangulo.EQUILÁTERO, HttpStatus.OK);
        }

        if ((valor1 == valor2) || (valor2 == valor3) || (valor1 == valor3)) {
            return new ResponseEntity<>(ClassificacaoTriangulo.ISÓSCELES, HttpStatus.OK);
        }

        if ((valor1 != valor2) && (valor2 != valor3) && (valor1 != valor3)) {
            return new ResponseEntity<>(ClassificacaoTriangulo.ESCALENO, HttpStatus.OK);
        }

        return new ResponseEntity<>(ClassificacaoTriangulo.INVÁLIDO, HttpStatus.BAD_REQUEST);
    }


    

}


