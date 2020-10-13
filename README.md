# connectedcars
{
	"info": {
		"_postman_id": "5cd21b30-909b-4fb4-b920-ce3db964609e",
		"name": "ConnectedCars",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "localhost:8080/ReadCSV",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/ReadCSV",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"ReadCSV"
					]
				}
			},
			"response": []
		},
		{
			"name": "UpdateCSV",
			"request": {
				"method": "PUT",
				"header": [],
				"url": {
					"raw": "localhost:8080/Update",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"Update"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8080/Store",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "filetype",
						"value": "CSV",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"id\" : 11,\r\n    \"name\" : \"\",\r\n    \"dob\" : \"27-05-1995\",\r\n    \"salary\" : 60000,\r\n    \"age\" : 25\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/Store",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"Store"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8080/ReadXML",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"name\": \"Manish\"\r\n    \r\n    }",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/ReadXML",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"ReadXML"
					]
				}
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}
