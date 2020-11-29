<template>
    <nav>
        <v-card>
            <v-navigation-drawer v-model="drawer" permanent dark  app style="background-color:#0D1E29; border-radius: 0 5px 5px 0">
            <v-list>
                <v-list-item>
                    <v-img
                    class="sideLogo"
                    max-height="150"
                    max-width="225"
                    src="@/static/images/logoWhite.svg"
                    >
                    </v-img>
                </v-list-item>
                <v-divider></v-divider>
                <v-list>
                    <v-list-item>
                        <v-list-item-action></v-list-item-action>
                    </v-list-item>
                </v-list>
                <v-list-item>
                     <v-list-item-avatar>
                    <v-img src="https://randomuser.me/api/portraits/men/21.jpg"></v-img>
                    </v-list-item-avatar>
                    <v-list-item-content>
                    <v-list-item-title class="title">
                        Олег Петров
                    </v-list-item-title>
                    <v-list-item-subtitle>petrov@gmail.com</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
            <!-- <v-divider></v-divider> -->
                <v-list nav dense rounded>
                    <v-list-item 
                    active-class="light-blue darken-3"
                    router to="/requestsList"
                    transition="fade-transition">
                        <v-list-item-icon>
                            <v-icon>list</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Все заявки</v-list-item-title>
                    </v-list-item>
                    <v-list-item 
                    router to="/myDesk"
                    transition="fade-transition"
                    active-class="light-blue darken-3"
                    >
                        <v-list-item-icon>
                            <v-icon>dashboard</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Мой профиль</v-list-item-title>
                    </v-list-item>
                    <v-list-item 
                    router to="/messageList"
                    transition="fade-transition"
                    active-class="light-blue darken-3"
                    >
                        <v-list-item-icon>
                            <v-icon>dashboard</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Мессенджер</v-list-item-title>
                    </v-list-item>
                        <v-list-group
                        no-action
                        sub-group
                        color="white"
                        active-class="light-blue darken-1"
                        >
                            <template v-slot:activator>
                                <v-list-item-content>
                                <v-list-item-title>Действия</v-list-item-title>
                                </v-list-item-content>
                            </template>
                            <createRequest/>
                           <v-list-item link>
                                <v-list-item-title>Удалить заявку</v-list-item-title>
                                <v-list-item-icon>
                                    <v-icon>delete</v-icon>
                                </v-list-item-icon>
                            </v-list-item>
                        </v-list-group>
                </v-list>
                <v-divider></v-divider>
                <v-list nav dense rounded>
                    <v-list-item 
                    router to="signInUp"
                    transition="hide-on-leave"
                    active-class="light-blue darken-3"
                    >
                        <v-list-item-icon>
                                <v-icon>fas fa-sign-out-alt</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Выйти</v-list-item-title>
                    </v-list-item>
                </v-list>
            </v-navigation-drawer>
        </v-card>
        
    </nav>
</template>

<script>
import createRequest from './createRequest.vue'

export default {
    name: 'Navbar',
    components: {
        createRequest,
    },
   data: () => ({
        admins: [
        ['Управление', 'account_box'],
        ['Настройки', 'settings_applications'],
        ],
        drawer: true,
        cruds: [
            ['Создать заявку', 'library_add'],
            ['Обновить список', 'library_add'],
            ['Удалить заявку', 'delete'],
        ],
    }),
}
</script>

<style scoped>

.sideLogo {
    margin: 10px 0px 20px 0px;
}

</style>
