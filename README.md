# TacoTotalizer
Backend webservice to total up Taco Loco orders

## Quick start
```
./mvnw clean package
java -jar target/TacoTotalizer-*.jar
```
<!-- Wow, that was simpler than I expected it to be.-->

By default, TacoTotalizer runs on port 8080; if you want to change this, pass it as a startup option, for example: `java -jar -Dserver.port=12345 target/TacoTotalizer-*.jar`

## API documentation
### /menu: Get the menu

URI | Methods allowed
--- | ---
`http://<host>/menu` | GET, POST

**Expects** an empty request body; any request body will be ignored.

**Returns** a JSON object containing a dictionary `menu`; dictionary keys are menu items and values are prices. Example:

```json
{
    "menu": {
        "Chorizo Taco": 3.5,
        "Chicken Taco": 3,
        "Beef Taco": 3,
        "Veggie Taco": 2.5
    }
}
```

### /ordertotal: Total up an order
URI | Methods allowed
--- | ---
`http://<host>/ordertotal` | POST

**Expects** in the request body a JSON object containing a string `orderID` and a dictionary `foodOrder`. `orderID` is a client-side correlation ID -- put anything you want as we don't save it or enforce uniqueness or sequentiality on it. `foodOrder` keys are menu items (as returned from the `/menu` endpoint) and values are quantity of that item. Example:

```json
{
	"orderID": "Allison",
	"foodOrder": {
		"Veggie Taco": 3,
		"Chorizo Taco": 1
	}
}
```

**Returns** a JSON object containing a string `orderID` (regurgitated from the request) and a floating-point number `total`. Example:

```json
{
    "orderID": "Allison",
    "total": 8.8
}
```
