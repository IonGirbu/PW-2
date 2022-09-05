# ToR
## News From Twitch
### Entities:
### User
```
{
  id: number(PK, autoincrement),
  name: string(required, min: 5: max: 20),
  password: string(required, min: 8, max: 30),
  email: string(required, min: 10, max:50)
}

```
### Posts
```
{
  id: number(PK, autoincrement),
  : number(FK, F),
  article: string(required, min: 10, max: 200),
  title: string(required, min: 3, max: 50),
  img:
}
