# Requirements

| ID  |     Description     |                   Endpoint                   | Type |
| :-: | :-----------------: | :------------------------------------------: | :--: |
|  1  |     Create User     |        "https://reqres.in/api/users"         | POST |
|  2  |   Get Single User   |    "https://reqres.in/api/users/{userID}"    | GET  |
|  3  |     List Users      |        "https://reqres.in/api/users"         | GET  |
|  4  |    Register User    |       "https://reqres.in/api/register"       | POST |
|  5  |        Login        |        "https://reqres.in/api/login"         | POST |
|  6  |   List Resources    |       "https://reqres.in/api/unknown"        | GET  |
|  7  | Get Single Resource | "https://reqres.in/api/unknown/{resourceID}" | GET  |

# 1. Application Test

To test the application we use Black-Box tests such as **Boundary-value analysis** and **Equivalence partitioning**.
All the tests that require a valid Login token, are executed with it.

## 1.1. Create User

Test if requirement works with valid arguments

|    Name    |               Input               | Status | Expected | Actual |
| :--------: | :-------------------------------: | :----: | :------: | :----: |
| Successful | `name:` "morpheus" `job:`"leader" |   ✔    |    Ok    |   Ok   |

### 1.1.1. Black-Box

Testing **NULL** and blank parameters in both arguments

|   Name    |               Input               | Status |        Expected        |         Actual         |
| :-------: | :-------------------------------: | :----: | :--------------------: | :--------------------: |
|  NullJob  | `name`: "morpheus" `job`:**NULL** |   ✔    | Invalid Job Exception  | Invalid Job Exception  |
| BlankJob  |   `name`: "morpheus" `job`:" "    |   ✔    | Invalid Job Exception  | Invalid Job Exception  |
| NullName  |  `name:` **NULL** `job:`"leader"  |   ✔    | Invalid Name Exception | Invalid Name Exception |
| BlankName |     `name:`"" `job:`"leader"      |   ✔    | Invalid Name Exception | Invalid Name Exception |

### Boundary-value analysis

Testing boundaries according to the following specifications:
![](https://i.imgur.com/a32zUWt.png)

|           Name           |                   Input                    | Status |           Expected           |            Actual            |
| :----------------------: | :----------------------------------------: | :----: | :--------------------------: | :--------------------------: |
| LowerInvalidBoundaryName |  `name:` String.length(1) `job:`"leader"   |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
|  LowerValidBoundaryName  |  `name:` String.length(2) `job:`"leader"   |   ✔    |              Ok              |              Ok              |
|  UpperValidBoundaryName  |  `name:` String.length(50) `job:`"leader"  |   ✔    |              Ok              |              Ok              |
| UpperInvalidBoundaryName |  `name:` String.length(51) `job:`"leader"  |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
| LowerInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(1)  |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |
|  LowerValidBoundaryJob   | `name:` "morpheus" `job:`String.length(2)  |   ✔    |              Ok              |              Ok              |
|  UpperValidBoundaryJob   | `name:` "morpheus" `job:`String.length(50) |   ✔    |              Ok              |              Ok              |
| UpperInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(51) |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |

## 1.2. Single User

Test if requirement works with valid arguments.

|    Name    | Description | Input | Status | Expected | Actual |
| :--------: | :---------: | :---: | :----: | :------: | :----: |
| Successful |  `id:` 10   |   ✔   |   ✔    |    Ok    |   Ok   |

### 1.2.1. Black-Box

|  Name   | Description | Input | Status |       Expected       |        Actual        |
| :-----: | :---------: | :---: | :----: | :------------------: | :------------------: |
| NulldId | `id:` null  |   ✔   |   ✔    | Invalid Id Exception | Invalid Id Exception |

### Boundary-value analysis

Testing boundaries according to the following specifications:
![](https://i.imgur.com/bCn3Uij.png)

|          Name          |   Input    | Status |       Expected       |        Actual        |
| :--------------------: | :--------: | :----: | :------------------: | :------------------: |
| LowerInvalidBoundaryId |   `id:`0   |   ✔    | Invalid Id Exception | Invalid Id Exception |
|  LowerValidBoundaryId  |   `id:`1   |   ✔    |          Ok          |          Ok          |
|  UpperValidBoundaryId  | `id:`10000 |   ✔    |          Ok          |          Ok          |
| UpperInvalidBoundaryId | `id:`10001 |   ✔    | Invalid Id Exception | Invalid Id Exception |

## 1.3. List Users

Test if requirement works with valid arguments

|    Name    | Input | Status | Expected | Actual |
| :--------: | :---: | :----: | :------: | :----: |
| Successful |       |   ✔    |    Ok    |   Ok   |

## 1.4. Register

Test if requirement works with valid arguments.

|    Name    |                          Input                          | Status | Expected | Actual |
| :--------: | :-----------------------------------------------------: | :----: | :------: | :----: |
| Successful | `email:` "eve.holt@reqres.in" `password:`"TestPassword" |   ✔    |    Ok    |   Ok   |

### 1.4.1. Black-Box

Testing **NULL** and blank parameters in both arguments.

|     Name      |                       Input                        | Status |          Expected          |           Actual           |
| :-----------: | :------------------------------------------------: | :----: | :------------------------: | :------------------------: |
| NullPassword  | `email`: "eve.holt@reqres.in" `password`: **NULL** |   ✔    | Invalid password Exception | Invalid Password Exception |
| BlankPassword |   `email`: "eve.holt@reqres.in" `password`: " "    |   ✔    | Invalid password Exception | Invalid Password Exception |
|   NullEmail   |    `email:` **NULL** `password:`"TestPassword"     |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |
|  BlankEmail   |       `email:` " " `password:`"TestPassword"       |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |

### Boundary-value analysis

Testing boundaries according to the following specifications:

Email Boundaries:
![](https://i.imgur.com/Se53J2p.png)

Password Boundaries:
![](https://i.imgur.com/2tsft3l.png)

|             Name             |                          Input                           | Status |          Expected          |           Actual           |
| :--------------------------: | :------------------------------------------------------: | :----: | :------------------------: | :------------------------: |
|  LowerInvalidBoundaryEmail   |    `email:`String.length(2) `password:`"TestPassword"    |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |
|   LowerValidBoundaryEmail    |    `email:`String.length(3) `password:`"TestPassword"    |   ✔    |             Ok             |             Ok             |
|   UpperValidBoundaryEmail    |   `email:`String.length(128) `password:`"TestPassword"   |   ✔    |             Ok             |             Ok             |
|  UpperInvalidBoundaryEmail   |   `email:`String.length(129) `password:`"TestPassword"   |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |
| LowerInvalidBoundaryPassword |  `email:`eve.holt@reqres.in `password:`String.length(7)  |   ✔    | Invalid Password Exception | Invalid Password Exception |
|  LowerValidBoundaryPassword  |  `email:`eve.holt@reqres.in `password:`String.length(8)  |   ✔    |             Ok             |             Ok             |
|  UpperValidBoundaryPassword  | `email:`eve.holt@reqres.in `password:`String.length(128) |   ✔    |             Ok             |             Ok             |
| UpperInvalidBoundaryPassword | `email:`eve.holt@reqres.in `password:`String.length(129) |   ✔    | Invalid Password Exception | Invalid Password Exception |

## 1.5. Login

Test if requirement works with valid arguments

|    Name    |                        Input                         | Status | Expected | Actual |
| :--------: | :--------------------------------------------------: | :----: | :------: | :----: |
| Successful | `email:`eve.holt@reqres.in `password:`"TestPassword" |   ✔    |    Ok    |   Ok   |

## 1.7. Single Resource

Test if requirement works with valid arguments.

|    Name    |  Input   | Status | Expected | Actual |
| :--------: | :------: | :----: | :------: | :----: |
| Successful | `id:` 10 |   ✔    |    Ok    |   Ok   |

## 1.8 Requests with no token

The following tests in chapter 1.8 were executed without a login token.

|            Name            |               Input               | Status |       Expected        |        Actual         |
| :------------------------: | :-------------------------------: | :----: | :-------------------: | :-------------------: |
|   createUserUnsuccessful   | `name:` "morpheus" `job:`"leader" |   ✔    | InvalidTokenException | InvalidTokenException |
| listResourcesUnsuccessful  |                                   |   ✔    | InvalidTokenException | InvalidTokenException |
|   listUsersUnsuccessful    |                                   |   ✔    | InvalidTokenException | InvalidTokenException |
| singleResourceUnsuccessful |             `id:` 10              |   ✔    | InvalidTokenException | InvalidTokenException |
|   singleUserUnsuccessful   |             `id:` 10              |   ✔    | InvalidTokenException | InvalidTokenException |

# 2. Gobal Tests

After the integration is complete global tests were excetuted in order to verify if the new modules are well implemented.
All the tests that require a valid Login token were executed with it.

## 2.1. Create User

Test if requirement works with valid arguments.

|    Name    |               Input               | Status | Expected | Actual |
| :--------: | :-------------------------------: | :----: | :------: | :----: |
| Successful | `name:` "morpheus" `job:`"leader" |   ✔    |    Ok    |   Ok   |

### 2.1.1. Black-Box

Testing **NULL** and blank parameters in both arguments.

|   Name    |               Input               | Status |        Expected        |         Actual         |
| :-------: | :-------------------------------: | :----: | :--------------------: | :--------------------: |
|  NullJob  | `name`: "morpheus" `job`:**NULL** |   ✔    | Invalid Job Exception  | Invalid Job Exception  |
| BlankJob  |   `name`: "morpheus" `job`:" "    |   ✔    | Invalid Job Exception  | Invalid Job Exception  |
| NullName  |  `name:` **NULL** `job:`"leader"  |   ✔    | Invalid Name Exception | Invalid Name Exception |
| BlankName |     `name:`"" `job:`"leader"      |   ✔    | Invalid Name Exception | Invalid Name Exception |

### Boundary-value analysis

Testing boundaries according to the following specifications:
![](https://i.imgur.com/a32zUWt.png)

|           Name           |                   Input                    | Status |           Expected           |            Actual            |
| :----------------------: | :----------------------------------------: | :----: | :--------------------------: | :--------------------------: |
| LowerInvalidBoundaryName |  `name:` String.length(1) `job:`"leader"   |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
|  LowerValidBoundaryName  |  `name:` String.length(2) `job:`"leader"   |   ✔    |              Ok              |              Ok              |
|  UpperValidBoundaryName  |  `name:` String.length(50) `job:`"leader"  |   ✔    |              Ok              |              Ok              |
| UpperInvalidBoundaryName |  `name:` String.length(51) `job:`"leader"  |   ✔    | Throw Invalid Name Exception | Throw Invalid Name Exception |
| LowerInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(1)  |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |
|  LowerValidBoundaryJob   | `name:` "morpheus" `job:`String.length(2)  |   ✔    |              Ok              |              Ok              |
|  UpperValidBoundaryJob   | `name:` "morpheus" `job:`String.length(50) |   ❌   |              Ok              |          Error: {}           |
| UpperInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(51) |   ✔    | Throw Invalid Job Exception  | Throw Invalid Job Exception  |

## 2.2. Single User

Test if requirement works with valid arguments

|    Name    | Description | Input | Status | Expected | Actual |
| :--------: | :---------: | :---: | :----: | :------: | :----: |
| Successful |  `id:` 10   |   ✔   |   ✔    |    Ok    |   Ok   |

### 2.2.1. Black-Box

|  Name   | Description | Input | Status |       Expected       |        Actual        |
| :-----: | :---------: | :---: | :----: | :------------------: | :------------------: |
| NulldId | `id:` null  |   ✔   |   ✔    | Invalid Id Exception | Invalid Id Exception |

### Boundary-value analysis

Testing boundaries according to the following specifications:
![](https://i.imgur.com/bCn3Uij.png)

|          Name           |   Input    | Status |       Expected       |        Actual        |
| :---------------------: | :--------: | :----: | :------------------: | :------------------: |
| LowerInvalidBoundaryJob |   `id:`0   |   ✔    | Invalid Id Exception | Invalid Id Exception |
| LowerValidBoundaryName  |   `id:`1   |   ✔    |          Ok          |          Ok          |
| UpperValidBoundaryName  | `id:`10000 |   ✔    |          Ok          |          Ok          |
| UpperInvalidBoundaryJob | `id:`10001 |   ✔    | Invalid Id Exception | Invalid Id Exception |

## 2.3. List Users

Test if requirement works with valid arguments

|    Name    | Input | Status | Expected | Actual |
| :--------: | :---: | :----: | :------: | :----: |
| Successful |       |   ✔    |    Ok    |   Ok   |

## 2.4. Register

Test if requirement works with valid arguments

|    Name    |                          Input                          | Status | Expected | Actual |
| :--------: | :-----------------------------------------------------: | :----: | :------: | :----: |
| Successful | `email:` "eve.holt@reqres.in" `password:`"TestPassword" |   ✔    |    Ok    |   Ok   |

### 2.4.1. Black-Box

Testing **NULL** and blank parameters in both arguments

|     Name      |                       Input                        | Status |          Expected          |           Actual           |
| :-----------: | :------------------------------------------------: | :----: | :------------------------: | :------------------------: |
| NullPassword  | `email`: "eve.holt@reqres.in" `password`: **NULL** |   ✔    | Invalid password Exception | Invalid Password Exception |
| BlankPassword |   `email`: "eve.holt@reqres.in" `password`: " "    |   ✔    | Invalid password Exception | Invalid Password Exception |
|   NullEmail   |    `email:` **NULL** `password:`"TestPassword"     |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |
|  BlankEmail   |       `email:` " " `password:`"TestPassword"       |   ✔    |  Invalid Email Exception   |  Invalid Email Exception   |

### Boundary-value analysis

Testing boundaries according to the following specifications:

Email Boundaries:
![](https://i.imgur.com/Se53J2p.png)

Password Boundaries:
![](https://i.imgur.com/2tsft3l.png)

|             Name             |                          Input                           | Status |          Expected          |                              Actual                              |
| :--------------------------: | :------------------------------------------------------: | :----: | :------------------------: | :--------------------------------------------------------------: |
|  LowerInvalidBoundaryEmail   |    `email:`String.length(2) `password:`"TestPassword"    |   ✔    |  Invalid Email Exception   |                     Invalid Email Exception                      |
|   LowerValidBoundaryEmail    |    `email:`String.length(3) `password:`"TestPassword"    |   ❌   |             Ok             | Error: {"error":"Note: Only defined users succeed registration"} |
|   UpperValidBoundaryEmail    |   `email:`String.length(128) `password:`"TestPassword"   |   ✔    |             Ok             |                                Ok                                |
|  UpperInvalidBoundaryEmail   |   `email:`String.length(129) `password:`"TestPassword"   |   ✔    |  Invalid Email Exception   |                     Invalid Email Exception                      |
| LowerInvalidBoundaryPassword |  `email:`eve.holt@reqres.in `password:`String.length(7)  |   ✔    | Invalid Password Exception |                    Invalid Password Exception                    |
|  LowerValidBoundaryPassword  |  `email:`eve.holt@reqres.in `password:`String.length(8)  |   ✔    |             Ok             |                                Ok                                |
|  UpperValidBoundaryPassword  | `email:`eve.holt@reqres.in `password:`String.length(128) |   ❌   |             Ok             | Error: {"error":"Note: Only defined users succeed registration"} |
| UpperInvalidBoundaryPassword | `email:`eve.holt@reqres.in `password:`String.length(129) |   ✔    | Invalid Password Exception |                    Invalid Password Exception                    |

## 2.5. Login

Test if requirement works with valid arguments.

|    Name    |                        Input                         | Status | Expected | Actual |
| :--------: | :--------------------------------------------------: | :----: | :------: | :----: |
| Successful | `email:`eve.holt@reqres.in `password:`"TestPassword" |   ✔    |    Ok    |   Ok   |

## 2.7. Single Resource

Test if requirement works with valid arguments.

|    Name    |  Input   | Status | Expected | Actual |
| :--------: | :------: | :----: | :------: | :----: |
| Successful | `id:` 10 |   ✔    |    Ok    |   Ok   |

## 2.8 Requests whit no token

The following tests in chapter 2.8 were executed without a login token.

|            Name            |               Input               | Status |       Expected        |        Actual         |
| :------------------------: | :-------------------------------: | :----: | :-------------------: | :-------------------: |
|   createUserUnsuccessful   | `name:` "morpheus" `job:`"leader" |   ✔    | InvalidTokenException | InvalidTokenException |
| listResourcesUnsuccessful  |                                   |   ✔    | InvalidTokenException | InvalidTokenException |
|   listUsersUnsuccessful    |                                   |   ✔    | InvalidTokenException | InvalidTokenException |
| singleResourceUnsuccessful |             `id:` 10              |   ✔    | InvalidTokenException | InvalidTokenException |
|   singleUserUnsuccessful   |             `id:` 10              |   ✔    | InvalidTokenException | InvalidTokenException |

# 3. REST Service Test

HTTP response status codes indicate whether a specific [HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP) request has been successfully completed. Responses are grouped in five classes: informational responses, successful responses, redirects, client errors, and servers errors.

| Status Code | Type |     Name     |                Description                 |
| :---------- | :--: | :----------: | :----------------------------------------: |
| 200         |  🟢  |      OK      |         The request has succeeded          |
| 201         |  🟢  |   Created    |      A new resource has been created       |
| 400         |  🔴  | Bad Request  |  Server could not understand the request   |
| 401         |  🔴  | Unauthorized |      Client must authenticate itself       |
| 404         |  🔴  |  Not Found   | The server can not find requested resource |

All the tests that require a valid Login token, are executed whit it.

Test if requirement works with valid arguments.

## 3.1. Create User

|                       Descrição                       |    Name    |               Input               | Status |  Expected  |    Actual    |
| :---------------------------------------------------: | :--------: | :-------------------------------: | :----: | :--------: | :----------: |
| Test if request with valid arguments returns 201 code | Successful | `name:` "morpheus" `job:`"leader" |   ✔    | `code:`201 | `code:`201 ` |

### 3.1.1. Black-Box

|                       Descrição                        |   Name    |              Input               | Status |  Expected   |   Actual   |
| :----------------------------------------------------: | :-------: | :------------------------------: | :----: | :---------: | :--------: |
| Test if request with **BLANK** Name returns error code | BlankName |    `name:`" " `job:`"leader"     |   ❌   | `code:`>399 | `code:`201 |
| Test if request with **NULL** Name returns error code  | NullName  |  `name:`**NULL** `job:`"leader"  |   ❌   | `code:`>399 | `code:`201 |
| Test if request with **BLANK** Job returns error code  | BlankJob  |   `name:`"morpheus" `job:`" "    |   ❌   | `code:`>399 | `code:`201 |
| Test if request with **NULL** Name returns error code  |  NullJob  | `name:`"morpheus" `job:`**NULL** |   ❌   | `code:`>399 | `code:`201 |

### Boundary-value analysis

Testing boundaries according to the following specifications:
![](https://i.imgur.com/a32zUWt.png)

|           Name           |                   Input                    | Status |  Expected   |   Actual   |
| :----------------------: | :----------------------------------------: | :----: | :---------: | :--------: |
| LowerInvalidBoundaryName |   `name:`String.length(1) `job:`"leader"   |   ❌   | `code:`>399 | `code:`201 |
|  LowerValidBoundaryName  |   `name:`String.length(2) `job:`"leader"   |   ✔    | `code:`201  | `code:`201 |
|  UpperValidBoundaryName  |  `name:`String.length(50) `job:`"leader"   |   ✔    | `code:`201  | `code:`201 |
| UpperInvalidBoundaryName |  `name:`String.length(51) `job:`"leader"   |   ❌   | `code:`>399 | `code:`201 |
| LowerInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(1)  |   ❌   | `code:`>399 | `code:`201 |
|  LowerValidBoundaryJob   | `name:` "morpheus" `job:`String.length(2)  |   ✔    | `code:`201  | `code:`201 |
|  UpperValidBoundaryJob   | `name:` "morpheus" `job:`String.length(50) |   ✔    | `code:`201  | `code:`201 |
| UpperInvalidBoundaryJob  | `name:` "morpheus" `job:`String.length(51) |   ❌   | `code:`>399 | `code:`201 |

## 3.2. Single User

#### 3.2.1. Black-Box

|                       Descrição                       |    Name    | Input  | Status |  Expected  |   Actual   |
| :---------------------------------------------------: | :--------: | :----: | :----: | :--------: | :--------: |
| Test if request with valid arguments returns 200 code | Successful | `id:`2 |   ✔    | `code:`200 | `code:`200 |

#### 3.2.2. Boundary-value analysis

Testing boundaries according to the following specifications:
![](https://i.imgur.com/bCn3Uij.png)

|          Name          |   Input    | Status |  Expected   |   Actual   |
| :--------------------: | :--------: | :----: | :---------: | :--------: |
| LowerInvalidBoundaryId |   `id:`0   |   ✔    | `code:`>399 | `code:`404 |
|  LowerValidBoundaryId  |   `id:`1   |   ✔    | `code:`200  | `code:`200 |
|  UpperValidBoundaryId  | `id:`10000 |   ❌   | `code:`200  | `code:`404 |
| UpperInvalidBoundaryId | `id:`10001 |   ✔    | `code:`>399 | `code:`404 |

### 3.3. List Users

#### 3.3.1. Black-Box

|                       Descrição                       |    Name    | Input | Status |  Expected  |   Actual   |
| :---------------------------------------------------: | :--------: | :---: | :----: | :--------: | :--------: |
| Test if request with valid arguments returns 200 code | Successful |       |   ✔    | `code:`200 | `code:`200 |

### 3.4. Register

|                       Descrição                       |    Name    |                          Input                          | Status |  Expected  |   Actual   |
| :---------------------------------------------------: | :--------: | :-----------------------------------------------------: | :----: | :--------: | :--------: |
| Test if request with valid arguments returns 200 code | Successful | `email:` "eve.holt@reqres.in" `password:`"TestPassword" |   ✔    | `code:`200 | `code:`200 |

#### 3.4.1. Black-Box

|                         Descrição                          |     Name      |                       Input                        | Status |  Expected   |   Actual   |
| :--------------------------------------------------------: | :-----------: | :------------------------------------------------: | :----: | :---------: | :--------: |
| Test if request with **NULL** Password returns error code  | NullPassword  | `email:` "eve.holt@reqres.in" `password:`**!NULL** |   ✔    | `code:`>399 | `code:`400 |
| Test if request with **BLANK** Password returns error code | BlankPassword |    `email:` "eve.holt@reqres.in" `password:`" "    |   ❌   | `code:`>399 | `code:`200 |
|  Test if request with **BLANK** Email returns error code   |  BlankEmail   |       `email:` " " `password:`"TestPassword"       |   ✔    | `code:`>399 | `code:`400 |
|   Test if request with **NULL** Email returns error code   |   NullEmail   |       `email:`**!NULL** `password:`"leader"        |   ✔    | `code:`>399 | `code:`400 |

### Boundary-value analysis

Testing boundaries according to the following specifications:

Email Boundaries:
![](https://i.imgur.com/Se53J2p.png)

Password Boundaries:
![](https://i.imgur.com/2tsft3l.png)

|             Name             |                          Input                           | Status |  Expected   |   Actual   |
| :--------------------------: | :------------------------------------------------------: | :----: | :---------: | :--------: |
|  LowerInvalidBoundaryEmail   |    `email:`String.length(2) `password:`"TestPassword"    |   ✔    | `code:`>399 | `code:`400 |
|   LowerValidBoundaryEmail    |    `email:`String.length(3) `password:`"TestPassword"    |   ❌   | `code:`200  | `code:`400 |
|   UpperValidBoundaryEmail    |   `email:`String.length(128) `password:`"TestPassword"   |   ❌   | `code:`200  | `code:`400 |
|  UpperInvalidBoundaryEmail   |   `email:`String.length(129) `password:`"TestPassword"   |   ✔    | `code:`>399 | `code:`400 |
| LowerInvalidBoundaryPassword |  `email:`eve.holt@reqres.in `password:`String.length(7)  |   ❌   | `code:`>399 | `code:`200 |
|  LowerValidBoundaryPassword  |  `email:`eve.holt@reqres.in `password:`String.length(8)  |   ✔    | `code:`200  | `code:`200 |
|  UpperValidBoundaryPassword  | `email:`eve.holt@reqres.in `password:`String.length(128) |   ✔    | `code:`200  | `code:`400 |
| UpperInvalidBoundaryPassword | `email:`eve.holt@reqres.in `password:`String.length(129) |   ❌   | `code:`>399 | `code:`200 |

### 3.5. Login

#### 3.5.1. Black-Box

|     Name     |                                     Input                                      | Status |                                                     Expected                                                     |                                                    Actual                                                    |
| :----------: | :----------------------------------------------------------------------------: | :----: | :--------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------: |
|  Successful  |             `email:` "eve.holt@reqres.in" `password:`"cityslicka"              |   ✔    | `code:`200 `content-type:`application/json {`email`:"eve.holt@reqres.in", `password:`"leader",`token:`**!NULL**} | `code:`200 `content-type:`application/json {`email`: "morpheus", `password:`"cityslicka", `token:`**!NULL**} |
| InvalidName  |                      `email:` "" `password:`"cityslicka"                       |   ✔    |                          `code:`400 `content-type:`application/json {`error`:**!NULL**}                          |                        `code:`400 `content-type:`application/json {`error`:**!NULL**}                        |
|   NullName   |                       `email:` null `password:`"leader"                        |   ✔    |                          `code:`400 `content-type:`application/json {`error`:**!NULL**}                          |                        `code:`400 `content-type:`application/json {`error`:**!NULL**}                        |
|  InvalidJob  |                  `email:` "eve.holt@reqres.in" `password:`""                   |   ✔    |                          `code:`400 `content-type:`application/json {`error`:**!NULL**}                          |                        `code:`400 `content-type:`application/json {`error`:**!NULL**}                        |
|   NullJob    |              `email:` "eve.holt@reqres.in" `password:`"**!NULL**"              |   ✔    |                          `code:`400 `content-type:`application/json {`error`:**!NULL**}                          |                        `code:`400 `content-type:`application/json {`error`:**!NULL**}                        |
| InvalidToken | `token:`"token_invalido" `email:` "eve.holt@reqres.in" `password:`"cityslicka" |   ❌   |                          `code:`400 `content-type:`application/json {`error`:**!NULL**}                          | `code:`200 `content-type:`application/json {`email`: "morpheus", `password:`"cityslicka", `token:`**!NULL**} |
|  NullToken   |     `token:`**NULL** `email:` "eve.holt@reqres.in" `password:`"cityslicka"     |   ❌   |                          `code:`400 `content-type:`application/json {`error`:**!NULL**}                          | `code:`200 `content-type:`application/json {`email`: "morpheus", `password:`"cityslicka", `token:`**!NULL**} |

### 3.6. List Resource

#### 3.6.1. Black-Box

|    Name    |   Type    | Description | Input | Status |  Expected  |   Actual   |
| :--------: | :-------: | :---------: | :---: | :----: | :--------: | :--------: |
| Successful | Black-Box |             |       |   ✔    | `code:`200 | `code:`200 |

### 3.7. Single Resource

#### 3.7.1. Black-Box

|    Name    |                 Input                 | Status |  Expected  |   Actual   |
| :--------: | :-----------------------------------: | :----: | :--------: | :--------: |
| Successful | `token:`"QpwL5tke4Pnpja7X4" `id:` "2" |   ✔    | `code:`200 | `code:`200 |

#### 3.7.2. Boundary-value analysis

| Name  |   Type    | Description |   Input    | Status |  Expected  |   Actual   |
| :---: | :-------: | :---------: | :--------: | :----: | :--------: | :--------: |
| MinId | Black Box |             |  `id:` 1   |   ✔    | `code:`200 | `code:`200 |
| MaxId | Black Box |             | `id:` 1000 |   ❌   | `code:`200 | `code:`404 | . |

#### 3.7.3. Equivalence partitioning

|    Name    |   Type    | Description |   Input    | Status |  Expected  |   Actual   |
| :--------: | :-------: | :---------: | :--------: | :----: | :--------: | :--------: |
| IdUnderMin | Black Box |             |  `id:` 0   |   ❌   | `code:`400 | `code:`404 |
| IdAboveMax | Black Box |             | `id:` 1001 |   ❌   | `code:`400 | `code:`404 |

| Descrição |     Name     |                           Input                            | Status |  Expected  |    Actual    |
| :-------: | :----------: | :--------------------------------------------------------: | :----: | :--------: | :----------: |
|     s     | InvalidToken | `token:`"token_invalido" `name:` "morpheus" `job:`"leader" |   ❌   | `code:`401 | `code:`201 ` |
|     s     |   NoToken    |     `token:`**NULL** `name:` "morpheus" `job:`"leader"     |   ❌   | `code:`401 | `code:`201 ` |
