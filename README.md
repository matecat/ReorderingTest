# JSON morphing and object grouping/re-ordering test.

## Introduzione

### Cosa ci aspettiamo
Ci aspettiamo un progetto Maven.

Quello che ci interessa è la qualità del tuo codice. 

Ci aspettiamo codice corretto, ordinato e ragionevolmente strutturato.

Ci aspettiamo la presenza di test unitari.

### Nice to have
Verrà valutata positivamente una buona code coverage.

### Limitazioni 

#### JVM
Ci aspettiamo codice scritto e compilabile per Java 8+.

Le nuove sintassi lambda sono accettate.

#### Librerie
Le uniche librerie accettate sono librerie necessarie al parsing del JSON e all'eventuale testing e deploy: Junit, mockito, ecc.


## Traccia

Da questa [URL](http://www.mocky.io/v2/5db8a72230000064005edf0d) da chiamare in GET sarà restituito un payload JSON
come quello in esempio nel file [`input.json`](https://github.com/matecat/ReorderingTest/blob/master/input.json).

Una volta ottenuto il payload, esso andrà letto, interpretato e trasformato in due JSON identici ( ovviamente non necessariamente nella formattazione ) a quelli presenti nei due files:
- [`output_fr-FR.json`](https://github.com/matecat/ReorderingTest/blob/master/output_fr-FR.json)
- [`output_it-IT.json`](https://github.com/matecat/ReorderingTest/blob/master/output_it-IT.json)

e scritti su disco, con i suddetti nomi, nella directory [`output`](https://github.com/matecat/ReorderingTest/tree/master/output). 
#### *Si noti che questi due files sono le effettive soluzioni dell'esercizio.*

## Descrizione del payload e dei fields
Partendo sempre dal JSON di input:

- `metadata` contiene un oggetto vuoto
- `export_phrases` contiene una lista di oggetti che definiscono una frase.

Ogni oggetto presente nel field `export_phrases` ha i seguenti fields:

- `value` che contiene il testo della frase
- `source_locale` che contiene la lingua sorgente
- `target_locales` che contiene una lista di uno o più oggetti `locale` che indicano la lingua di destinazione in cui andrebbe tradotta la frase.
- `created_at` che contiene la data di quando la frase è stata generata
- `collection_name` che contiene il nome della collection a cui la frase appartiene

## Regole di Raggruppamento

### Primo raggruppamento
Il primo raggruppamento deve avvenire per lingua, quindi, ogni file di output prodotto conterrà una sola lingua target che sarà posta nel field metadata oltre che aggiunta al nome del file di
 output per poterlo distinguere.
```
{
  "metadata": {
    "source_locale": "en",
    "target_locale": "it-IT"
  },
  ...
}
```
Vanno quindi esclusi dal file output corrispondente le frasi che non hanno il locale specificato.

> Esempio:
>
> La frase `value: "If it hollers let it go"` ha nella lista `target_locales` un solo oggetto `locale: "fr-FR"` e quindi essa dovrà essere presente solo nel file output francese.

### Secondo raggruppamento
Il secondo raggruppamento deve avvenire sulla base del campo `collection_name`, le frasi che appartengono alla stessa collection devono essere raggruppate.
```
{
  ...
  "collections": [
    {
      "name": "counting_rhyme",
      "export_phrases": [
        { ... }, { ... }
      ]
    }
  ]
}
```
### Ordinamento delle collections
Contestualmente al raggruppamento ( preferibilmente ) o in iterazioni successive, le collection vanno ordinate alfabeticamente.

> Esempio:
> nel file [`output_fr-FR.json`](https://github.com/matecat/ReorderingTest/blob/master/output_fr-FR.json) le collection sono ordinate:
> 1. `counting_rhyme` 
> 2. `sing_that_song`

### Ordinamento delle phrases
All'interno delle collections, le phrases devono essere ordinate in maniera **crescente** sulla base della data `created_at`.

## Conclusione
Se le regole di raggruppamento e ordinamento verranno rispettate i file json di output risulteranno identici a quelli forniti nella traccia.
