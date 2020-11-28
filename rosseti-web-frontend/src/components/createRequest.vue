<template>
  <v-dialog
    v-model="dialog"
    fullscreen
    hide-overlay
    transition="dialog-bottom-transition"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-list-item v-bind="attrs" v-on="on">
        <v-list-item-title>Создать заявку</v-list-item-title>
        <v-list-item-icon>
            <v-icon>library_add</v-icon>
        </v-list-item-icon>
    </v-list-item>
    </template>
    <v-card>
      <v-toolbar
        dark
        color="primary"
      >
        <v-btn
          icon
          dark
          @click="dialog = false"
        >
          <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-toolbar-title>Создать заявку на рационализаторское предложение</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn
            dark
            text
            @click="dialog = false"
          >
            Сохранить
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
      <v-list
        three-line
      >
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>Заполните поля</v-list-item-title>
            <v-form class="px-3">
              <v-layout row wrap>
                <v-flex xs12 md5 ma-5>
                  <v-text-field
                    name="name"
                    label="Название проекта"
                    prepend-icon="drive_file_rename_outline"
                    v-model="title"
                  ></v-text-field>
                  <v-select
                  :items="items"
                  prepend-icon="category"
                  label="Область предложения"
                  v-model="category"
                  ></v-select>
                  <v-text-field
                    name="name"
                    label="Соавторы"
                    prepend-icon="person"
                    v-model="title"
                  ></v-text-field>
                  <v-text-field
                    label="Описание положительного эффекта"
                    name="name"
                    prepend-icon="add"
                    v-model="disadvantage"
                    textarea
                  ></v-text-field>
                  <v-text-field
                    label="Описание недостатков актуальной системы"
                    name="name"
                    prepend-icon="minimize"
                    v-model="advantage"
                    textarea
                  ></v-text-field>
                </v-flex>
                <v-flex xs12 md6 my-5>
                    <v-file-input
                      counter
                      multiple
                      show-size
                      small-chips
                      placeholder="Необходимые документы"
                      truncate-length="15"
                    ></v-file-input>
                    <v-file-input
                      counter
                      multiple
                      show-size
                      small-chips
                      placeholder="Дополнительные файлы"
                      truncate-length="15"
                    ></v-file-input>
                    <v-textarea
                      name="input-7-1"
                      label="Экономический эффект"
                      filled
                      v-model="ecoEffect"
                      prepend-icon="description"
                      hint="Введите текст"
                    ></v-textarea>
                </v-flex>
              </v-layout>
            </v-form>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-divider></v-divider>
      <v-list
        three-line
        subheader
      >
        <v-subheader>Описательная часть</v-subheader>
              <div class="container">
                <!-- Use the component in the right place of the template -->
                <tiptap-vuetify
                  v-model="content"
                  :extensions="extensions"
                  placeholder="Это описательная часть заявления. Начинайте писать здесь.."
                  :toolbar-attributes="{ color: 'yellow' }"
                  elevation="0"
                  min-height="900px"
                  :card-props="{ flat: true, color: 'grey lighten-3' }"
                />
              </div>
      </v-list>
    </v-card>
  </v-dialog>
</template>

<script>

import { TiptapVuetify, Heading, Bold, Italic, Strike, Underline, Code, Paragraph, BulletList, OrderedList, ListItem, Link, Blockquote, HardBreak, HorizontalRule, History } from 'tiptap-vuetify';

  export default {
    name: 'createRequest',
    components: {
      TiptapVuetify,
    },
    data: () => ({
    dialog: false,
    extensions: [
      History,
      Blockquote,
      Link,
      Underline,
      Strike,
      Italic,
      ListItem,
      BulletList,
      OrderedList,
      [Heading, {
        options: {
          levels: [1, 2, 3]
        }
      }],
      Bold,
      Code,
      HorizontalRule,
      Paragraph,
      HardBreak
    ],
    // starting editor's content
    content: `
      <h1>Оформить описательную часть можно</h1>
      <p>в данном окне</strong> окне.</p>
    `
  })
    
  }
</script>

<style scoped>

</style>