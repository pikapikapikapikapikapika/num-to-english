# num-to-english #
Num to English is a web application that translates a given number to its English equivalent. 

## Usage ##
/num_to_english accepts GET requests that include a JSON parameter. The parameter should be as follows:

```{number: <String representation of a number to be translated into English>}```
 
The response will also be a JSON object whose schema is as follows:
```
{
  status: <"ok" if the translation is as follows. Otherwise a string description of what prevented the translation.>
  num_in_english: <The input number translated to english. Only present if the translation was successful.>
}
```
