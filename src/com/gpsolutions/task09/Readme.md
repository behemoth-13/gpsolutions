###Тождество

#####(Время: 1 сек. Память: 16 Мб Сложность: 32%)

Вам необходимо проверить домашнюю работу Васи Пупкина, в которой он написал равенство. Например, запись вида «2+3=5» 
является правильной, а «23*7=421» неверная, но корректная. Корректной записью выражения будем называть 
последовательность: число, операция («+», «-», «*», «/»), число, знак равенства, число. Т.е. если в записи не хватает
 цифр или же встречается неизвестный символ. Например, записи «2*=3», «173» и «2+2=a» некорректны.

####Входные данные

Входной файл INPUT.TXT состоит из единственной строки, содержащей запись арифметического выражения. Все числа в записи 
целые и не превышают по абсолютной величине 30000. Длина арифметического выражения может быть от 0 до 100 символов.

####Выходные данные

В выходной файл OUTPUT.TXT нужно вывести «YES», если указанная запись правильна (т.е. равенство представляет собой 
тождество), «NO» - если корректная, но неверная и «ERROR», если в записи присутствуют ошибки.

####Примеры

>INPUT.TXT  
>
>     2+3=5
>	
>OUTPUT.TXT  
> 
>     YES

>INPUT.TXT  
>
>     3*7=20
>	
>OUTPUT.TXT  
> 
>     NO

>INPUT.TXT  
>
>     two plus three is five
>	
>OUTPUT.TXT  
> 
>     ERROR
