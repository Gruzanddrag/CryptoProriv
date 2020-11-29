<template>
<v-app class="blue-grey lighten-5">
    <div class="dashboard">
        <h1 class="ma-10" style="color:#0D1E29;">Список чатов</h1>
            <v-flex>
                <v-card
                    d-flex align-start flex-column mb-6
                    class="ma-10 pa-3"
                    max-width="655"
                    tile
                    v-for="message in messages"
                    :key="message.id"
                >
                    <v-list-item three-line>
                    <v-list-item-content>
                        <div class="overline mb-4">
                        Пользователь:
                        </div>
                        <v-list-item-title class="headline mb-1">
                        {{ message.name }}
                        </v-list-item-title>
                        <v-list-item-subtitle>{{ message.title }}</v-list-item-subtitle>
                    </v-list-item-content>

                    <v-list-item-avatar
                        style="border-radius: 50%;"
                        tile
                        size="80"
                    >
                    <v-img style="border-radius: 50%;" :src="message.url"></v-img>
                    </v-list-item-avatar>
                    </v-list-item>

                    <v-card-actions>
                    <v-btn
                        outlined
                        rounded
                        color="primary"
                    >
                        Открыть диалог
                    </v-btn>
                    </v-card-actions>
                </v-card>           
            </v-flex>
    </div>
</v-app>
</template>

<script>
export default {
    name: 'messegeList',
    data: () => ({
        messages: [
            { 'name': 'Андрей Каравлин', 'title':'Пришли новые правки по идее.', 'url':'https://randomuser.me/api/portraits/men/22.jpg' },
            { 'name': 'Александр Ашаров', 'title':'Проверь почту.', 'url':'https://randomuser.me/api/portraits/men/23.jpg' },
            { 'name': 'Никита Бебулахов', 'title':'Сегодня выйду в офис пораньше.', 'url':'https://randomuser.me/api/portraits/men/11.jpg' },
            { 'name': 'Никита Балахов', 'title':'Нужно срочно менять дизайнера.', 'url':'https://randomuser.me/api/portraits/men/13.jpg' },
            { 'name': 'Артём Поляничев', 'title':'Фронтендер не справляется.', 'url':'https://randomuser.me/api/portraits/men/15.jpg' },
            { 'name': 'Кирилл Чеботарёв', 'title':'Помоги фронтендеру придумать текст.', 'url':'https://randomuser.me/api/portraits/men/14.jpg' },
            { 'name': 'Артём Татевосян', 'title':'Заглушки наше всё', 'url':'https://randomuser.me/api/portraits/men/1.jpg' },
        ], 
    }),
}
</script>