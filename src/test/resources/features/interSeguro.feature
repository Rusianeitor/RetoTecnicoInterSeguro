Feature: Inter Seguro
  Como usuario quiero hacer acciones en la página de Interseguro

  Background:
    Given quiero cotizar un seguro de viaje

  @All @ResumenCompraAdultoSolo @Happypath
  Scenario Outline: Cotizar seguro de viaje para adulto
    When selecciono el mas barato
      | destino | adulto   | niño | documento | celular   |
      | Europa  | <adulto> | 0    | 11111111  | 986589748 |
    Then se muestra el resumen de mi compra
    Examples:
      | adulto |
      | 3      |
      | 4      |

  @All @ResumenCompraAdultoYNiño @Happypath
  Scenario: Cotizar seguro de viaje para adulto y niño
    When selecciono el mas barato
      | destino | adulto | niño | documento | celular   |
      | Europa  | 1      | 2    | 11111111  | 986589748 |
    Then se muestra el resumen de mi compra

  @All @SinDestino @Unhappypath
  Scenario: Cotizar seguro de viaje sin destino
    When no selecciono destino
    Then se muestra mensaje validacion por destino "Este campo es requerido"

  @All @SinDocumento @Unhappypath
  Scenario: Cotizar seguro de viaje documento incorrecto
    When ingreso documento menor a 8 digitos
      | documento |
      | 11111     |
    Then se muestra mensaje validacion por documento "Documento inválido"