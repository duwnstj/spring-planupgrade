{
	"info": {
		"_postman_id": "1b715e9d-af84-4939-8153-503df13c4766",
		"name": "일정 업그레이드 버전",
		"description": "일정 저장, 일정 단건 조회,",
		"schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
		"_exporter_id": "37566103"
	},
	"item": [
		{
			"name": "일정 저장",
			"request": {
				"method": "POST",
				"header": [],
				"url": "",
				"description": "# 일정을 저장하는 API입니다."
			},
			"response": []
		},
		{
			"name": "단건 조회",
			"request": {
				"method": "GET",
				"header": [],
				"url": "http://localhost:8080/api/schedules/1"
			},
			"response": []
		},
		{
			"name": "일정 수정",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"userName\" : \"duwnstj\",\r\n    \"title\" : \"일정 제목입니다.\",\r\n    \"content\" : \"일정 내용입니다.\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": "http://localhost:8080/api/schedules/1"
			},
			"response": []
		}
	]
}