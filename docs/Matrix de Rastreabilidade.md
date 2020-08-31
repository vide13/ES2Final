# Requirements

| ID - Chapter |     Description     |
| :----------: | :-----------------: |
|      1       |     Create User     |
|      2       |   Get Single User   |
|      3       |     List Users      |
|      4       |    Register User    |
|      5       |        Login        |
|      6       |   List Resources    |
|      7       | Get Single Resource |

# 1. Application Test

To test the application we use Black-Box tests such as **Boundary-value analysis** and **Equivalence partitioning**.

## 1.1. Create User

### 1.1.1. White-Box

|    Name    | Description |               Input                | Status |        Expected        |         Actual         |
| :--------: | :---------: | :--------------------------------: | :----: | :--------------------: | :--------------------: |
| Successful |             | `name:` "morpheus" `job:`"leader"  |   ✔    |     Does Not Throw     |     Does Not Throw     |
|  NullJob   |             | `name`: "morpheus" `job`: **NULL** |   ✔    |   Null Job Exception   |   Null Job Exception   |
|  BlankJob  |             |   `name`: "morpheus" `job`: " "    |   ✔    | Invalid Job Exception  | Invalid Job Exception  |
|  NullName  |             |  `name:` **NULL** `job:`"leader"   |   ✔    |  Null Name Exception   |  Null Name Exception   |
| BlankName  |             |     `name:` "" `job:`"leader"      |   ✔    | Invalid Name Exception | Invalid Name Exception |

### 1.1.2. Boundary-value analysis

|           Name           |                   Input                    | Status |           Expected           |            Actual            |
| :----------------------: | :----------------------------------------: | :----: | :--------------------------: | :--------------------------: |
| LowerInvalidBoundaryName |  `name:` String.length(1) `job:`"leader"   |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
|  LowerValidBoundaryName  |  `name:` String.length(2) `job:`"leader"   |   ✔    |        Does Not Throw        |        Does Not Throw        |
|  UpperValidBoundaryName  |  `name:` String.length(50) `job:`"leader"  |   ✔    |        Does Not Throw        |        Does Not Throw        |
| UpperInvalidBoundaryName |  `name:` String.length(51) `job:`"leader"  |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
| LowerInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(1)  |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |
|  LowerValidBoundaryJob   | `name:` "morpheus" `job:`String.length(2)  |   ✔    |        Does Not Throw        |        Does Not Throw        |
|  UpperValidBoundaryJob   | `name:` "morpheus" `job:`String.length(50) |   ✔    |        Does Not Throw        |        Does Not Throw        |
| UpperInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(51) |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |

## 1.2. Single User

### 1.2.1. White-Box

|  Name   | Type | Description | Input | Status |     Expected      |      Actual       |
| :-----: | :--: | :---------: | :---: | :----: | :---------------: | :---------------: |
| NulldId |      | `id:` null  |   ✔   |   ✔    | Null Id Exception | Null Id Exception |

### 1.2.2. Boundary-value analysis

|          Name           |   Type    | Description |   Input    | Status |       Expected       |        Actual        |
| :---------------------: | :-------: | :---------: | :--------: | :----: | :------------------: | :------------------: |
| LowerInvalidBoundaryJob | White-Box |             |   `id:`0   |   ✔    | Invalid Id Exception | Invalid Id Exception |
| LowerValidBoundaryName  | White-Box |             |   `id:`1   |   ✔    |    Does Not Throw    |    Does Not Throw    |
| UpperValidBoundaryName  | White-Box |             | `id:`10000 |   ✔    |    Does Not Throw    |    Does Not Throw    |
| UpperInvalidBoundaryJob | White-Box |             | `id:`10001 |   ✔    | Invalid Id Exception | Invalid Id Exception |

## 1.3. List Users

### 1.3.1. White-Box

|    Name    |   Type    | Description | Input | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :---: | :----: | :------------: | :------------: |
| Successful | White-Box |             |       |   ✔    | Does Not Throw | Does Not Throw |

## 1.4. Register

### 1.4.1. White-Box

|     Name      | Description |                          Input                          | Status |          Expected          |           Actual           |
| :-----------: | :---------: | :-----------------------------------------------------: | :----: | :------------------------: | :------------------------: |
|  Successful   |             | `email:` "eve.holt@reqres.in" `password:`"TestPassword" |   ✔    |       Does Not Throw       |       Does Not Throw       |
| NullPassword  |             |   `email`: "eve.holt@reqres.in" `password`: **NULL**    |   ✔    | Invalid password Exception | Invalid Password Exception |
| BlankPassword |             |      `email`: "eve.holt@reqres.in" `password`: " "      |   ✔    | Invalid password Exception | Invalid Password Exception |
|   NullEmail   |             |       `email:` **NULL** `password:`"TestPassword"       |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |
|  BlankEmail   |             |         `email:` " " `password:`"TestPassword"          |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |

### 1.4.2. Boundary-value analysis

|             Name             |   Type    | Description |                          Input                           | Status |          Expected          |           Actual           |
| :--------------------------: | :-------: | :---------: | :------------------------------------------------------: | :----: | :------------------------: | :------------------------: |
|  LowerInvalidBoundaryEmail   | White Box |             |    `email:`String.length(2) `password:`"TestPassword"    |   ✔    | Invalid Password Exception | Invalid Password Exception |
|   LowerValidBoundaryEmail    | White Box |             |    `email:`String.length(3) `password:`"TestPassword"    |   ✔    |       Does Not Throw       |       Does Not Throw       |
|   UpperValidBoundaryEmail    | White Box |             |   `email:`String.length(128) `password:`"TestPassword"   |   ✔    |       Does Not Throw       |       Does Not Throw       |
|  UpperInvalidBoundaryEmail   | White Box |             |   `email:`String.length(129) `password:`"TestPassword"   |   ✔    | Invalid Password Exception | Invalid Password Exception |
| LowerInvalidBoundaryPassword | White Box |             |  `email:`eve.holt@reqres.in `password:`String.length(7)  |   ✔    | Invalid Password Exception | Invalid Password Exception |
|  LowerValidBoundaryPassword  | White Box |             |  `email:`eve.holt@reqres.in `password:`String.length(8)  |   ✔    |       Does Not Throw       |       Does Not Throw       |
|  UpperValidBoundaryPassword  | White Box |             | `email:`eve.holt@reqres.in `password:`String.length(128) |   ✔    |       Does Not Throw       |       Does Not Throw       |
| UpperInvalidBoundaryPassword | White Box |             | `email:`eve.holt@reqres.in `password:`String.length(129) |   ✔    | Invalid Password Exception | Invalid Password Exception |

## 1.5. Login

### 1.5.1. White-Box

|    Name    |   Type    | Description |                        Input                         | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :--------------------------------------------------: | :----: | :------------: | :------------: |
| Successful | White Box |             | `email:`eve.holt@reqres.in `password:`"TestPassword" |   ✔    | Does Not Throw | Does Not Throw |

## 1.7. Single Resource

### 1.7.1. White-Box

|    Name    |   Type    | Description |  Input   | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :------: | :----: | :------------: | :------------: |
| Successful | White-Box |             | `id:` 10 |   ✔    | Does Not Throw | Does Not Throw |

# 2. Global Test

## 2.1. Create User

### 2.1.1. White-Box

|    Name    | Description |               Input                | Status |        Expected        |         Actual         |
| :--------: | :---------: | :--------------------------------: | :----: | :--------------------: | :--------------------: |
| Successful |             | `name:` "morpheus" `job:`"leader"  |   ✔    |     Does Not Throw     |     Does Not Throw     |
|  NullJob   |             | `name`: "morpheus" `job`: **NULL** |   ✔    |   Null Job Exception   |   Null Job Exception   |
|  BlankJob  |             |   `name`: "morpheus" `job`: " "    |   ✔    | Invalid Job Exception  | Invalid Job Exception  |
|  NullName  |             |  `name:` **NULL** `job:`"leader"   |   ✔    |  Null Name Exception   |  Null Name Exception   |
| BlankName  |             |     `name:` "" `job:`"leader"      |   ✔    | Invalid Name Exception | Invalid Name Exception |

### 2.1.2. Boundary-value analysis

|           Name           |                   Input                    | Status |           Expected           |            Actual            |
| :----------------------: | :----------------------------------------: | :----: | :--------------------------: | :--------------------------: |
| LowerInvalidBoundaryName |  `name:` String.length(1) `job:`"leader"   |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
|  LowerValidBoundaryName  |  `name:` String.length(2) `job:`"leader"   |   ✔    |        Does Not Throw        |        Does Not Throw        |
|  UpperValidBoundaryName  |  `name:` String.length(50) `job:`"leader"  |   ✔    |        Does Not Throw        |        Does Not Throw        |
| UpperInvalidBoundaryName |  `name:` String.length(51) `job:`"leader"  |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
| LowerInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(1)  |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |
|  LowerValidBoundaryJob   | `name:` "morpheus" `job:`String.length(2)  |   ✔    |        Does Not Throw        |        Does Not Throw        |
|  UpperValidBoundaryJob   | `name:` "morpheus" `job:`String.length(50) |   ✔    |        Does Not Throw        |        Does Not Throw        |
| UpperInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(51) |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |

## 2.2. Single User

### 2.2.1. White-Box

|  Name   | Type | Description | Input | Status |     Expected      |      Actual       |
| :-----: | :--: | :---------: | :---: | :----: | :---------------: | :---------------: |
| NulldId |      | `id:` null  |   ✔   |   ✔    | Null Id Exception | Null Id Exception |

### 2.2.2. Boundary-value analysis

|          Name           |   Type    | Description |   Input    | Status |       Expected       |        Actual        |
| :---------------------: | :-------: | :---------: | :--------: | :----: | :------------------: | :------------------: |
| LowerInvalidBoundaryJob | White-Box |             |   `id:`0   |   ✔    | Invalid Id Exception | Invalid Id Exception |
| LowerValidBoundaryName  | White-Box |             |   `id:`1   |   ✔    |    Does Not Throw    |    Does Not Throw    |
| UpperValidBoundaryName  | White-Box |             | `id:`10000 |   ✔    |    Does Not Throw    |    Does Not Throw    |
| UpperInvalidBoundaryJob | White-Box |             | `id:`10001 |   ✔    | Invalid Id Exception | Invalid Id Exception |

## 2.3. List Users

### 2.3.1. White-Box

|    Name    |   Type    | Description | Input | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :---: | :----: | :------------: | :------------: |
| Successful | White-Box |             |       |   ✔    | Does Not Throw | Does Not Throw |

## 2.4. Register

### 2.4.1. White-Box

|     Name      | Description |                          Input                          | Status |          Expected          |           Actual           |
| :-----------: | :---------: | :-----------------------------------------------------: | :----: | :------------------------: | :------------------------: |
|  Successful   |             | `email:` "eve.holt@reqres.in" `password:`"TestPassword" |   ✔    |       Does Not Throw       |       Does Not Throw       |
| NullPassword  |             |   `email`: "eve.holt@reqres.in" `password`: **NULL**    |   ✔    | Invalid password Exception | Invalid Password Exception |
| BlankPassword |             |      `email`: "eve.holt@reqres.in" `password`: " "      |   ✔    | Invalid password Exception | Invalid Password Exception |
|   NullEmail   |             |       `email:` **NULL** `password:`"TestPassword"       |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |
|  BlankEmail   |             |         `email:` " " `password:`"TestPassword"          |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |

### 2.4.2. Boundary-value analysis

|             Name             |   Type    | Description |                          Input                           | Status |          Expected          |           Actual           |
| :--------------------------: | :-------: | :---------: | :------------------------------------------------------: | :----: | :------------------------: | :------------------------: |
|  LowerInvalidBoundaryEmail   | White Box |             |    `email:`String.length(2) `password:`"TestPassword"    |   ✔    | Invalid Password Exception | Invalid Password Exception |
|   LowerValidBoundaryEmail    | White Box |             |    `email:`String.length(3) `password:`"TestPassword"    |   ✔    |       Does Not Throw       |       Does Not Throw       |
|   UpperValidBoundaryEmail    | White Box |             |   `email:`String.length(128) `password:`"TestPassword"   |   ✔    |       Does Not Throw       |       Does Not Throw       |
|  UpperInvalidBoundaryEmail   | White Box |             |   `email:`String.length(129) `password:`"TestPassword"   |   ✔    | Invalid Password Exception | Invalid Password Exception |
| LowerInvalidBoundaryPassword | White Box |             |  `email:`eve.holt@reqres.in `password:`String.length(7)  |   ✔    | Invalid Password Exception | Invalid Password Exception |
|  LowerValidBoundaryPassword  | White Box |             |  `email:`eve.holt@reqres.in `password:`String.length(8)  |   ✔    |       Does Not Throw       |       Does Not Throw       |
|  UpperValidBoundaryPassword  | White Box |             | `email:`eve.holt@reqres.in `password:`String.length(128) |   ✔    |       Does Not Throw       |       Does Not Throw       |
| UpperInvalidBoundaryPassword | White Box |             | `email:`eve.holt@reqres.in `password:`String.length(129) |   ✔    | Invalid Password Exception | Invalid Password Exception |

## 2.5. Login

### 2.5.1. White-Box

|    Name    |   Type    | Description |                        Input                         | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :--------------------------------------------------: | :----: | :------------: | :------------: |
| Successful | White Box |             | `email:`eve.holt@reqres.in `password:`"TestPassword" |   ✔    | Does Not Throw | Does Not Throw |

## 2.7. Single Resource

### 2.7.1. White-Box

|    Name    |   Type    | Description |  Input   | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :------: | :----: | :------------: | :------------: |
| Successful | White-Box |             | `id:` 10 |   ✔    | Does Not Throw | Does Not Throw |

# 3. REST Service Test

HTTP response status codes indicate whether a specific [HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP) request has been Successfully completed. Responses are grouped in five classes: informational responses, Successful responses, redirects, client errors, and servers errors.

| Status Code | Type |     Name     |                Description                 |
| :---------: | :--: | :----------: | :----------------------------------------: |
|     200     |  🟢  |      OK      |         The request has succeeded          |
|     201     |  🟢  |   Created    |      A new resource has been created       |
|     400     |  🔴  | Bad Request  |  Server could not understand the request   |
|     401     |  🔴  | Unauthorized |      Client must authenticate itself       |
|     404     |  🔴  |  Not Found   | The server can not find requested resource |

### 3.1. Create User

#### 3.1.1. Black-Box

|     Name     |                              Input                              | Status |                                        Expected                                        |                                          Actual                                          |
| :----------: | :-------------------------------------------------------------: | :----: | :------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------: |
|  Successful  |  `token:`"QpwL5tke4Pnpja7X4" `name:` "morpheus" `job:`"leader"  |   ✔    | `code:` 201 {`name`:"morpheus", `job:`"leader", `id:`**!NULL**, `createdAt:`**!NULL**} |  `code:`201 {`name`:"morpheus", `job:`"leader", `id:`**!NULL**, `createdAt:`**!NULL**}   |
|   NullJob    | `token:`"QpwL5tke4Pnpja7X4" `name:` "morpheus" `job:`"**NULL**" |   ❌   |                             `code:`400 {`error`:**!NULL**}                             | `code:`201 {`name`:"morpheus, `job:`"**!NULL**", `id:`**!NULL**, `createdAt:`**!NULL**}` |
|   BlankJob   |    `token:`"QpwL5tke4Pnpja7X4" `name:` "morpheus" `job:`" "     |   ❌   |                             `code:`400 {`error`:**!NULL**}                             |     `code:`201 {`name`:"morpheus", `job:`"", `id:`**!NULL**, `createdAt:`**!NULL**}`     |
|   NullName   |   `token:`"QpwL5tke4Pnpja7X4" `name:` **NULL** `job:`"leader"   |   ❌   |                             `code:`400 {`error`:**!NULL**}                             |  `code:`201 {`name`:"**NULL**", `job:`"leader", `id:`**!NULL**, `createdAt:`**!NULL**}`  |
|  BlankName   |     `token:`"QpwL5tke4Pnpja7X4" `name:` " " `job:`"leader"      |   ❌   |                             `code:`400 {`error`:**!NULL**}                             |      `code:`201 {`name`:"", `job:`"leader", `id:`**!NULL**, `createdAt:`**!NULL**}`      |
| InvalidToken |   `token:`"token_invalido" `name:` "morpheus" `job:`"leader"    |   ❌   |                             `code:`401 {`error`:**!NULL**}                             |  `code:`201 {`name`:"morpheus", `job:`"leader", `id:`**!NULL**, `createdAt:`**!NULL**}`  |
|  NullToken   |       `token:`**NULL** `name:` "morpheus" `job:`"leader"        |   ❌   |                             `code:`401 {`error`:**!NULL**}                             |  `code:`201 {`name`:"morpheus", `job:`"leader", `id:`**!NULL**, `createdAt:`**!NULL**}`  |

### 3.2. Single User

#### 3.2.1. Black-Box

|    Name    |                 Input                 | Status |  Expected  |   Actual   |
| :--------: | :-----------------------------------: | :----: | :--------: | :--------: |
| Successful | `token:`"QpwL5tke4Pnpja7X4" `id:` "2" |   ✔    | `code:`200 | `code:`200 |

#### 3.2.2. Boundary-value analysis

| Name  |   Type    | Description |   Input    | Status |  Expected  |   Actual   |
| :---: | :-------: | :---------: | :--------: | :----: | :--------: | :--------: |
| MinId | Black Box |             |  `id:` 1   |   ✔    | `code:`200 | `code:`200 |
| MaxId | Black Box |             | `id:` 1000 |   ❌   | `code:`200 | `code:`404 | . |

#### 3.2.3. Equivalence partitioning

|    Name    |   Type    | Description |   Input    | Status |  Expected  |   Actual   |
| :--------: | :-------: | :---------: | :--------: | :----: | :--------: | :--------: |
| IdUnderMin | Black Box |             |  `id:` 0   |   ❌   | `code:`400 | `code:`404 |
| IdAboveMax | Black Box |             | `id:` 1001 |   ❌   | `code:`400 | `code:`404 |

### 3.3. List Users

|    Name    |   Type    | Description | Input | Status |    Expected    |     Actual     |
| :--------: | :-------: | :---------: | :---: | :----: | :------------: | :------------: |
| Successful | White-Box |             |       |   ✔    | Does Not Throw | Does Not Throw |

### 3.4. Register

### 3.5. Login

### 3.6. List Resource

### 3.7. Single Resource
