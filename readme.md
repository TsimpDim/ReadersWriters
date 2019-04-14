# Tsimpitas Dimitris dai17131 [Readers- Writers]

## Example Execution:
### Server
---
Server Waiting
->INIT STATE<-
Flight    |Status    |Time      
----------|----------|--------
WD623     |DEPARTING |22:22     
          |          |          
VL001     |BOARDING  |17:02     
          |          |          
HZ205     |EN ROUTE  |17:02     
          |          |          
CX183     |EN ROUTE  |07:07     
          |          |          


Flight    |Status    |Time      
----------|----------|--------
WD623     |DEPARTING |22:22     
          |          |          
VL001     |BOARDING  |17:02     
          |          |          
HZ205     |DEPARTING |12:03     
          |          |          
CX183     |EN ROUTE  |07:07     
          |          |          


Flight    |Status    |Time      
----------|----------|--------
WD623     |DEPARTING |22:22     
          |          |          
VL001     |BOARDING  |17:02     
          |          |          
HZ205     |DEPARTING |12:03     
          |          |          
CX183     |EN ROUTE  |12:31     
          |          |          


Flight    |Status    |Time      
----------|----------|--------
WD623     |DEPARTING |22:22     
          |          |          
VL001     |BOARDING  |03:53     
          |          |          
HZ205     |DEPARTING |12:03     
          |          |          
CX183     |EN ROUTE  |12:31     
          |          |          


### Clients 
---
```
C5[R] sending request
C3[R] sending request
C7[R] sending request
C5[R] received a reply:
	Reply opcode = ROK | Reply value = {time=17:02, status=BOARDING}
C13[W] sending request
C7[R] received a reply:
	Reply opcode = ROK | Reply value = {time=07:07, status=EN ROUTE}
C3[R] received a reply:
	Reply opcode = ROK | Reply value = {time=17:02, status=BOARDING}
C13[W] received a reply:
	Reply opcode = WOK | Reply value = null
C10[R] sending request
C4[R] sending request
C10[R] received a reply:
	Reply opcode = ROK | Reply value = {time=07:07, status=EN ROUTE}
C1[R] sending request
C4[R] received a reply:
	Reply opcode = ROK | Reply value = {time=17:02, status=BOARDING}
C12[W] sending request
C1[R] received a reply:
	Reply opcode = ROK | Reply value = {time=22:22, status=DEPARTING}
C12[W] received a reply:
	Reply opcode = WOK | Reply value = null
C2[R] sending request
C6[R] sending request
C2[R] received a reply:
	Reply opcode = ROK | Reply value = {time=22:22, status=DEPARTING}
C11[W] sending request
C6[R] received a reply:
	Reply opcode = ROK | Reply value = {time=12:03, status=DEPARTING}
C11[W] received a reply:
	Reply opcode = WOK | Reply value = null
C9[R] sending request
C9[R] received a reply:
	Reply opcode = ROK | Reply value = {time=03:53, status=BOARDING}
C8[R] sending request
C8[R] received a reply:
	Reply opcode = ROK | Reply value = {time=03:53, status=BOARDING}
```

## Code Structure
![code structure](https://i.postimg.cc/Twv0P3Gh/Untitled-Diagram.png)
