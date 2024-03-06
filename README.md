# Mockito --> no es algo propio de java, sino de cualquier lenguaje de programacion.
Curso de Mockito

Un test unitario , se basa en un test con una sola responsabilidad.

Stub --> se le reprograman los valores de retorno y se lo ofrecemos al objeto bajo prueba.
Mock  --> es al igual que el stub el cual se puede programar su comportamiento , pero una vez finalizada las pruebas se puede revisar.
Spy  --> hereda comportamiento de mock, pero se basa principalmente en la implementacion real del objeto pero agrega capacidad dre tastrear y registrar iteraciones.

1. Mock de dependenias bajo test.
2. Ejecutar codigo de la clase bajo test
3. Validar si el codigo ejecutado es el esperado..

   DEPENDENCIA MOCKITO -->       <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>4.0.0</version>
            <scope>test</scope>
        </dependency>
# Cuando se crea la clase mockito especifica para el test, Usar la libreria Mockito.mock("objeto.class").

1.mockear dependencia

Mockito.verify--> verifica que se cumple

@Mock --> indica que es un mock

@InjectMocks --> en el objeto que le pongo la etiqueta, van a ser inyectados con el mocke declarado con la etiqueta anterior.

when("metodo que queremos usar ")--> palabra reservada de mock 
.thenReturn("lO QUE QUIERO QUE ME DEVUELVA.." ej: true o false.)

 
//ARRANGE --> organizar todo lo que queremos testear.
//ACT
//Assert
    
//Given --> Nos permite inicializar el stub osea el objeto bajo prueba y sus mock
//When --> operacion que se da sujeto al tst --> con test unitarios.
/Then  --> se verifica si el test es correcto.
    estos componentes, son iguales con distintos nombres, van a lo mismo.
------------------------------------------------------------------------------------------------------------------------------
# ArgumentMatcher()--> nos permite personalizar lo que esperamos de respuesta en el chek ejemplo : 

    public void argumentMatcher(){

        //Given
        given(validateNumber.checkNumber(anyInt())).willReturn(true);
        given(validateNumber.checkNumber(5)).willReturn(true);
        //When
        int result = sumar.sumar(4,5);
        //Then
        assertEquals(9,result);

# spy --> nos creo una emboltura alrededor de una instancia, lo cual podemos llamar al objeto y verificar el mismo.
