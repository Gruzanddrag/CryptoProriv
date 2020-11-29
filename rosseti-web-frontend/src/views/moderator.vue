<template>
    <div class="mx-6">
        <v-row>
            <v-col>
                <h1> Проверка заявления</h1>
            </v-col>
        </v-row>
        <div class="ma-4">

            <v-row>
                <v-col>
                    <h2>{{ statement.name }}</h2>
                </v-col>
            </v-row>
            <v-row class="px-6">
                <v-flex xs4 md2>
                    <div class="caption grey--text my-1"><v-icon left medium>date_range</v-icon>Дата</div>
                    <div>{{ d = new Date(statement.createdAt * 1000).getDate() + '/' + (new Date(statement.createdAt * 1000).getMonth()) + '/' + new Date(statement.createdAt * 1000).getFullYear() + " " + new Date(statement.createdAt * 1000).getHours() + ':' + new Date(statement.createdAt * 1000).getMinutes() }}</div>
                </v-flex>
                <v-flex xs4 md2>
                    <div class="caption grey--text my-1"><v-icon left medium>person</v-icon>Сотрудник</div>
                    <div>{{ statement.author.fIO }}</div>
                </v-flex>
            </v-row>
            <v-row>
                <v-col>
                    <v-card  class="pa-10">
                        <v-card-title>
                            <span class="headline">Описательная часть</span>
                        </v-card-title>
                        <v-card-text>
                            <span v-html="statement.projectDescription"></span>
                        </v-card-text>
                        <v-card-title>
                            <span class="headline">Описание положительного эффекта</span>
                        </v-card-title>
                        <v-card-text>
                            <span v-html="statement.advantagesDescription"></span>
                        </v-card-text>
                        <v-card-title>
                            <span class="headline">Описание экономического эффекта</span>
                        </v-card-title>
                        <v-card-text>
                            <span v-html="statement.economicEffect"></span>
                        </v-card-text>
                        <v-card-title>
                            <span class="headline">Новизна</span>
                        </v-card-title>
                        <v-card-text>
                            <span v-html="statement.newness"></span>
                        </v-card-text>
                    </v-card>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-subheader>
                        Прикрепленные документы
                    </v-subheader>
                    <v-chip class="mr-2" color="blue" dark>
                        <v-icon small left>
                            mdi-file
                        </v-icon>
                        Чертеж продукта
                    </v-chip>
                    <v-chip class="mr-2" color="blue" dark>
                        <v-icon small left>
                            mdi-file
                        </v-icon>
                        Инструкция
                    </v-chip>
                    <v-chip class="mr-2" color="blue" dark>
                        <v-icon small left>
                            mdi-file
                        </v-icon>
                        Экономическая эффективность (расчеты)
                    </v-chip>

                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-timeline
                            dense
                            clipped
                    >
                        <v-slide-x-transition
                                group
                        >
                            <v-timeline-item
                                    v-for="event in timeline"
                                    :key="event.id"
                                    class="mb-4"
                                    color="pink"
                                    small
                            >
                                <v-row justify="space-between">
                                    <v-col
                                            cols="7"
                                            v-text="event.text"
                                    ></v-col>
                                    <v-col
                                            class="text-right"
                                            cols="5"
                                            v-text="event.time"
                                    ></v-col>
                                </v-row>
                            </v-timeline-item>
                        </v-slide-x-transition>

                        <v-timeline-item
                                class="mb-6"
                                hide-dot
                        >
                            <span style="font-weight:900;">Прогресс обработки заявления</span>
                        </v-timeline-item>

                        <v-timeline-item
                                class="mb-4"
                                color="grey"
                                icon-color="grey lighten-2"
                                small
                        >
                            <v-row justify="space-between">
                                <v-col cols="7">
                                    Заявление подано.
                                </v-col>
                                <v-col
                                        class="text-right"
                                        cols="5"
                                >
                                    15:26 по МСК
                                </v-col>
                            </v-row>
                        </v-timeline-item>

                        <v-timeline-item
                                class="mb-4"
                                small
                                color="grey"
                        >
                            <v-row justify="space-between">
                                <v-col cols="7">
                                    <v-chip
                                            class="white--text ml-0"
                                            color="purple"
                                            label
                                            small
                                    >
                                        Этап 1
                                    </v-chip>
                                    Первичное рассмотрение заявления.
                                </v-col>
                                <v-col
                                        class="text-right"
                                        cols="5"
                                >
                                    02:25 по МСК
                                </v-col>
                            </v-row>
                        </v-timeline-item>

                        <v-timeline-item
                                class="mb-4"
                                color="grey"
                                small
                        >
                            <v-row justify="space-between">
                                <v-col cols="7">
                                    <v-chip
                                            class="white--text ml-0"
                                            color="warning"
                                            label
                                            small
                                    >
                                        Этап 2
                                    </v-chip>
                                    Централизованная регистрация заявления.
                                </v-col>
                                <v-col
                                        class="text-right"
                                        cols="5"
                                >
                                    07:15 по МСК
                                </v-col>
                            </v-row>
                        </v-timeline-item>
                        <v-timeline-item
                                class="mb-4"
                                color="cyan"
                                small
                        >
                            <v-row justify="space-between">
                                <v-col cols="7">
                                    <v-chip
                                            class="white--text ml-0"
                                            color="cyan"
                                            label
                                            small
                                    >
                                        Этап 3
                                    </v-chip>
                                    Подготовка для рассмотрения первым ЗГД.
                                </v-col>
                                <v-col
                                        class="text-right"
                                        cols="5"
                                >
                                    14:00 по МСК
                                </v-col>
                            </v-row>
                        </v-timeline-item>
                    </v-timeline>
                </v-col>
            </v-row>
            <v-row class="mb-12">
                <v-col>
                    <div class="d-flex justify-end">
                        <v-btn class="mr-2" dark color="green">
                            Принять!
                        </v-btn>
                        <v-btn dark color="red">
                            Отклонить!
                        </v-btn>
                    </div>
                </v-col>
            </v-row>
        </div>
    </div>
</template>

<script>
import axios from 'axios'


export default {
    name: 'moderator',
    data: () => {
        return {
            statement: {}
        }
    },
    created() {
      this.reloadStatement()
    },
    methods: {
        reloadStatement() {
             axios.get(this.$store.state.apiurl + 'statements/1')
                .then(res => {
                    this.statement = res.data
                })
        }
    }
}
</script>
